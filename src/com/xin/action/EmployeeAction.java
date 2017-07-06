package com.xin.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Date;

import javax.annotation.Resource;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xin.bean.Employee;
import com.xin.bean.LeavePersonInfo;
import com.xin.bean.LeaveSchoolPerson;
import com.xin.exception.ExcelException;
import com.xin.service.IEmployeeManage;
import com.xin.service.ILeaveSchoolPersonManage;
import com.xin.util.ExcelUtil;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class EmployeeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Employee employee;
	
	private File excelFile;
	
	public File getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(File excelFile) {
		this.excelFile = excelFile;
	}

	public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    
        /**
         * 创建一个新的实例 EmployeeAction.
         *
         */
        
    public EmployeeAction() {
        super();
    }

    @Resource
	private IEmployeeManage employeeManage;
	@Resource
	private ILeaveSchoolPersonManage leaveSchoolPersonManage;	

	public ILeaveSchoolPersonManage getLeaveSchoolPersonManage() {
		return leaveSchoolPersonManage;
	}

	public void setLeaveSchoolPersonManage(
			ILeaveSchoolPersonManage leaveSchoolPersonManage) {
		this.leaveSchoolPersonManage = leaveSchoolPersonManage;
	}

	public Employee getEmployee() {
		return employee;
	}	

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setEmployeeManage(IEmployeeManage employeeManage) {
		this.employeeManage = employeeManage;
	}

	public IEmployeeManage getEmployeeManage() {
		return employeeManage;
	}
	
	private File employeeFile;

	public File getEmployeeFile() {
		return employeeFile;
	}

	public void setEmployeeFile(File employeeFile) {
		this.employeeFile = employeeFile;
	}
	
	private File stopEmployeeFile;	

	public File getStopEmployeeFile() {
		return stopEmployeeFile;
	}

	public void setStopEmployeeFile(File stopEmployeeFile) {
		this.stopEmployeeFile = stopEmployeeFile;
	}

	private Integer eId;
	private Date leaveDate;
	private String leaveReason;
	private String business;
	
	public Integer getEId() {
		return eId;
	}

	public void setEId(Integer eId) {
		this.eId = eId;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	private String salaryState;
	private Date stopDate;
	private String remark;
	
	public String getSalaryState() {
		return salaryState;
	}

	public void setSalaryState(String salaryState) {
		this.salaryState = salaryState;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private Integer queryId;
	private String queryName;
	private String queryDepartment;
	
	public Integer getQueryId() {
		return queryId;
	}

	public void setQueryId(Integer queryId) {
		this.queryId = queryId;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQueryDepartment() {
		return queryDepartment;
	}

	public void setQueryDepartment(String queryDepartment) {
		this.queryDepartment = queryDepartment;
	}
		
	public static boolean isValid(int value) {
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
	}

	public String addEmployee() {
		System.out.println("-------employeeAction.addEmployee--------"
				+ employee.getId());
		if (isValid(employee.getId())) {
			employeeManage.addEmployee(employee);
			ActionContext.getContext().getSession()
					.put("addedEmployee", employee);
			ActionContext.getContext().getSession()
			.put("alertInfo", "增加成功！");
			return "success";
		}
		return "fail";
		
	}

	public String modifyEmployee() {
		System.out.println("-------employeeAction.modifyEmployee--------"
				+ employee.getId());
		if (isValid(employee.getId())
				&& employeeManage.findEmployeeById(employee.getId()) != null) {
			employeeManage.modifyEmployee(employee);
			return "success";
		}
		return "fail";
	}

	public String getEmployeeInfo() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		System.out.println("-------employeeAction.getEmployeeInfo--------"
				+ employee.getId());
		if (employee.getId() == null) {
			session.put("resultInfo", "职工号为空");
			return "success";
		}
		if (isValid(employee.getId())
				&& employeeManage.findEmployeeById(employee.getId()) != null) {
			Integer eid = employee.getId();
			employee = employeeManage.findEmployeeById(eid);
			session.put("eInfo", employee);
			return "success";
		}
		session.put("resultInfo", "职工号不存在！");
		return "success";
	}
	
	public String importEmployeeInfo() throws FileNotFoundException, ExcelException {
		System.out.println("-------employeeAction.importEmployeeInfo--------");
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (employeeFile != null) {
			List<Employee> employeeList = new ArrayList<Employee>();
			InputStream in = new FileInputStream(employeeFile);
			LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
			fieldMap.put("职工号", "id");
			fieldMap.put("姓名", "name");
			fieldMap.put("邮箱", "email");
			fieldMap.put("性别", "gender");
			fieldMap.put("出生日期", "birthday");
			fieldMap.put("身份证号", "uid");
			fieldMap.put("单位", "department");
			fieldMap.put("岗位性质", "jobType");
			fieldMap.put("人员身份", "type");
			fieldMap.put("进校来源", "source");
			fieldMap.put("入校报到时间", "reachSchoolDate");
			fieldMap.put("最高学历", "maxEducation");
			fieldMap.put("最高学历获得时间", "maxEducationDate");
			fieldMap.put("最高学位", "maxDegree");
			fieldMap.put("最高学位获得时间", "maxDegreeDate");
			fieldMap.put("聘任职务", "hireWork");
			fieldMap.put("职务级别", "workLevel");
			fieldMap.put("任职时间", "startWorkDate");
			fieldMap.put("聘任职称", "hireTitle");
			fieldMap.put("职称级别", "titleLevel");
			fieldMap.put("聘任时间", "hireDate");
			fieldMap.put("（拟）聘任岗位", "hireJob");
			fieldMap.put("聘岗级别", "jobLevel");
			String[] uniqueFields = {"职工号"};	
			try {
			employeeList = ExcelUtil.excelToList(in, "Sheet1", Employee.class, fieldMap, uniqueFields);			
			for (Employee e : employeeList) {				
				employeeManage.addEmployee(e);
			}
			
			session.put("employeeList", employeeList);
			session.put("alertInfo", "导入完成！");
			return "success";
			}
			catch (ExcelException e) {
				session.put("alertInfo", e.getMessage());
				return "importFail";
			}
		}
		else {
			session.put("alertInfo", "文件有错请重新选择!");
			return "importFail";
		}
		
	}
	
	public String importStopEmployeeInfo() throws FileNotFoundException, ExcelException {
		System.out.println("-------employeeAction.importStopEmployeeInfo--------");
		if (stopEmployeeFile != null) {
			List<LeaveSchoolPerson> leavePersonList = new ArrayList<LeaveSchoolPerson>();
			InputStream in = new FileInputStream(stopEmployeeFile);
			LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
			fieldMap.put("职工号", "eId");
			fieldMap.put("离校时间","leaveSchoolDate");
			fieldMap.put("离校原因", "leaveReason");
			fieldMap.put("工资状态", "salaryState");
			fieldMap.put("停发时间", "stopDate");
			fieldMap.put("备注", "note");
			String[] uniqueFields = {"职工号"};	
			leavePersonList = ExcelUtil.excelToList(in, "Sheet1", LeaveSchoolPerson.class, fieldMap, uniqueFields);			
			List<LeavePersonInfo> lPInfoList = new ArrayList<LeavePersonInfo>();
			for (LeaveSchoolPerson lPerson : leavePersonList) {
				LeavePersonInfo lPInfo = new LeavePersonInfo();
				lPInfo.seteId(lPerson.geteId());
				if (employeeManage.findEmployeeById(lPInfo.geteId()) == null) {
					System.out.println("您输入的数据有误，职工号"+lPInfo.geteId()+"不存在！");
					return "fail";
				}
				lPInfo.setName(employeeManage.findEmployeeById(lPerson.geteId()).getName());
				lPInfo.setGender(employeeManage.findEmployeeById(lPerson.geteId()).getGender());
				lPInfo.setDepartment(employeeManage.findEmployeeById(lPerson.geteId()).getDepartment());
				lPInfo.setLeaveDate(lPerson.getLeaveSchoolDate());
				lPInfo.setReason(lPerson.getLeaveReason());
				lPInfo.setState(lPerson.getSalaryState());
				lPInfo.setStopDate(lPerson.getStopDate());
				lPInfo.setNote(lPerson.getNote());
				lPInfoList.add(lPInfo);
			}
			
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("lList", lPInfoList);
			session.put("leaveList", leavePersonList);
		}
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public String infoSubmit() {
		System.out.println("-------employeeAction.infoSubmit--------");
		Map<?, ?> session = ActionContext.getContext().getSession();
		List<LeaveSchoolPerson> leavePersonList = (ArrayList<LeaveSchoolPerson>)session.get("leaveList");
		for (LeaveSchoolPerson lPerson : leavePersonList) {
			System.out.println(lPerson.getNote());
			leaveSchoolPersonManage.addLeaveSchoolPerson(lPerson);
		}
		ActionContext.getContext().getSession().put("rightInfo", "导入成功！");
		return "success";
	}
	
	public String infoSubmit2() {
		System.out.println("-------employeeAction.infoSubmit2--------");
		System.out.println(eId);
		if (!isValid(eId)) {
			System.out.println("您的输入有误！职工号"+eId+"不存在");
			ActionContext.getContext().getSession().put("rightInfo", "您的输入有误！职工号"+eId+"不存在");
			return "success";
		}
		if (employeeManage.findEmployeeById(eId) == null) {
			System.out.println("您的输入有误！职工号"+eId+"不存在");
			ActionContext.getContext().getSession().put("rightInfo", "您的输入有误！职工号"+eId+"不存在");
			return "success";
		}
		LeaveSchoolPerson lSPerson = new LeaveSchoolPerson();
		lSPerson.seteId(eId);
		lSPerson.setLeaveReason(leaveReason);
		lSPerson.setLeaveSchoolDate(leaveDate);
		lSPerson.setNote(remark);
		lSPerson.setSalaryState(salaryState);
		lSPerson.setStopDate(stopDate);
		leaveSchoolPersonManage.addLeaveSchoolPerson(lSPerson);
		
		ActionContext.getContext().getSession().put("rightInfo", "导入成功！");
		return "success";
	}
	
	public String query() {
		System.out.println("-------employeeAction.query--------");
		if (queryId == null && queryName.equals("") && queryDepartment.equals("")) {
			List<LeaveSchoolPerson> leList = (ArrayList<LeaveSchoolPerson>)leaveSchoolPersonManage.findLeaveSchoolPersonsList();
			List<LeavePersonInfo> lPInfoList = new ArrayList<LeavePersonInfo>();
			for (LeaveSchoolPerson lPerson:leList) {
				LeavePersonInfo lPInfo = new LeavePersonInfo();
				lPInfo.seteId(lPerson.geteId());
				lPInfo.setDepartment(employeeManage.findEmployeeById(lPerson.geteId()).getDepartment());
				lPInfo.setGender(employeeManage.findEmployeeById(lPerson.geteId()).getGender());
				lPInfo.setLeaveDate(lPerson.getLeaveSchoolDate());
				lPInfo.setName(employeeManage.findEmployeeById(lPerson.geteId()).getName());
				lPInfo.setNote(lPerson.getNote());
				lPInfo.setReason(lPerson.getLeaveReason());
				lPInfo.setState(lPerson.getSalaryState());
				lPInfo.setStopDate(lPerson.getStopDate());
				lPInfoList.add(lPInfo);
			}
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("queryList", lPInfoList);
			return "success";
		}
		if (queryId != null) {
			System.out.println("Query_ID");
			if (!isValid(queryId)) {
				System.out.println("职工号不符合规范！");
				return "fail";
			} else {
				if (employeeManage.findEmployeeById(queryId) == null) {
					System.out.println("查询职工号不存在！");
					return "fail";
				} else {
					List<LeavePersonInfo> lPInfoList = new ArrayList<LeavePersonInfo>();
					LeavePersonInfo lPInfo = new LeavePersonInfo();
					lPInfo.setName(employeeManage.findEmployeeById(queryId).getName());
					lPInfo.setGender(employeeManage.findEmployeeById(queryId).getGender());
					lPInfo.setDepartment(employeeManage.findEmployeeById(queryId).getDepartment());
					if (leaveSchoolPersonManage.findLeaveSchoolPersonByEId(queryId) != null) {
						lPInfo.setLeaveDate(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(queryId).getLeaveSchoolDate());
						lPInfo.setReason(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(queryId).getLeaveReason());
						lPInfo.setState(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(queryId).getSalaryState());
						lPInfo.setStopDate(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(queryId).getStopDate());
						lPInfo.setNote(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(queryId).getNote());
						lPInfoList.add(lPInfo);
					}
					
					Map<String, Object> session = ActionContext.getContext().getSession();
					session.put("queryList", lPInfoList);
					
					return "success";
				}
			}
		} else {
			if (!queryName.equals("")) {
				System.out.println("Query_Name");
				List<LeavePersonInfo> lPInfoList = new ArrayList<LeavePersonInfo>();
				List<Employee> nameList = new ArrayList<Employee>();
				nameList = employeeManage.findEmployeesByName(queryName);
				for (Employee e : nameList) {
					Integer q_id = e.getId();
					LeavePersonInfo lPInfo = new LeavePersonInfo();
					lPInfo.setName(employeeManage.findEmployeeById(q_id).getName());
					lPInfo.setGender(employeeManage.findEmployeeById(q_id).getGender());
					lPInfo.setDepartment(employeeManage.findEmployeeById(q_id).getDepartment());
					if (leaveSchoolPersonManage.findLeaveSchoolPersonByEId(q_id) != null) {
						lPInfo.setLeaveDate(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(q_id).getLeaveSchoolDate());
						lPInfo.setReason(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(q_id).getLeaveReason());
						lPInfo.setState(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(q_id).getSalaryState());
						lPInfo.setStopDate(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(q_id).getStopDate());
						lPInfo.setNote(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(q_id).getNote());
						
						lPInfoList.add(lPInfo);
					}
				}
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("queryList", lPInfoList);
				
				return "success";
			} else {				
				if (!queryDepartment.equals("")) {
					System.out.println("Query_Department");
					List<LeavePersonInfo> lPInfoList = new ArrayList<LeavePersonInfo>();
					List<Employee> departmentList = new ArrayList<Employee>();
					departmentList = employeeManage.findEmployeesByDepartment(queryDepartment);
					for (Employee e : departmentList) {
						Integer q_id = e.getId();
						LeavePersonInfo lPInfo = new LeavePersonInfo();
						lPInfo.setName(employeeManage.findEmployeeById(q_id).getName());
						lPInfo.setGender(employeeManage.findEmployeeById(q_id).getGender());
						lPInfo.setDepartment(employeeManage.findEmployeeById(q_id).getDepartment());
						if (leaveSchoolPersonManage.findLeaveSchoolPersonByEId(q_id) != null) {
							lPInfo.setLeaveDate(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(q_id).getLeaveSchoolDate());
							lPInfo.setReason(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(q_id).getLeaveReason());
							lPInfo.setState(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(q_id).getSalaryState());
							lPInfo.setStopDate(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(q_id).getStopDate());
							lPInfo.setNote(leaveSchoolPersonManage.findLeaveSchoolPersonByEId(q_id).getNote());
						
							lPInfoList.add(lPInfo);
						}
					}
					Map<String, Object> session = ActionContext.getContext().getSession();
					session.put("queryList", lPInfoList);
					
					return "success";
				} else {
					return "fail";
				}
			}
		}
	}
}
