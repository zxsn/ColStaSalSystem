package com.xin.action;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xin.bean.ManagePaylevelSalary;
import com.xin.bean.ManagePositionSalary;
import com.xin.bean.ProfessionalPaylevelSalary;
import com.xin.bean.ProfessionalPositionSalary;
import com.xin.bean.WorkerPaylevelSalary;
import com.xin.bean.WorkerPositionSalary;
import com.xin.service.IManageSalaryManage;
import com.xin.service.IProfSalaryManage;
import com.xin.service.IWorkerSalaryManage;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class SalaryStandardAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String tableName;
	private String position;
	private Integer level;
	private Integer salaryStandard;
	private Integer startPayLevel;
	private String type;
	private Integer payLevel;
	private Integer payLevelSalaryStandard;
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSalaryStandard() {
		return salaryStandard;
	}

	public void setSalaryStandard(Integer salaryStandard) {
		this.salaryStandard = salaryStandard;
	}

	public Integer getStartPayLevel() {
		return startPayLevel;
	}

	public void setStartPayLevel(Integer startPayLevel) {
		this.startPayLevel = startPayLevel;
	}

	public Integer getPayLevel() {
		return payLevel;
	}

	public void setPayLevel(Integer payLevel) {
		this.payLevel = payLevel;
	}

	public Integer getPayLevelSalaryStandard() {
		return payLevelSalaryStandard;
	}

	public void setPayLevelSalaryStandard(Integer payLevelSalaryStandard) {
		this.payLevelSalaryStandard = payLevelSalaryStandard;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	private ManagePositionSalary managePositionSalary;
	
	public ManagePositionSalary getManagePositionSalary() {
		return managePositionSalary;
	}

	public void setManagePositionSalary(ManagePositionSalary managePositionSalary) {
		this.managePositionSalary = managePositionSalary;
	}
	
	
	private ManagePaylevelSalary managePaylevelSalary;

	public ManagePaylevelSalary getManagePaylevelSalary() {
		return managePaylevelSalary;
	}

	public void setManagePaylevelSalary(ManagePaylevelSalary managePaylevelSalary) {
		this.managePaylevelSalary = managePaylevelSalary;
	}
	
	public IWorkerSalaryManage getWorkerSalaryManage() {
		return workerSalaryManage;
	}

	public void setWorkerSalaryManage(IWorkerSalaryManage workerSalaryManage) {
		this.workerSalaryManage = workerSalaryManage;
	}

	public IProfSalaryManage getProfSalaryManage() {
		return profSalaryManage;
	}

	public void setProfSalaryManage(IProfSalaryManage profSalaryManage) {
		this.profSalaryManage = profSalaryManage;
	}

	@Resource
	private IManageSalaryManage manageSalaryManage;

	@Resource
	private IWorkerSalaryManage workerSalaryManage;
	
	@Resource 
	private IProfSalaryManage profSalaryManage;

	public IManageSalaryManage getManageSalaryManage() {
		return manageSalaryManage;
	}

	public void setManageSalaryManage(IManageSalaryManage manageSalaryManage) {
		this.manageSalaryManage = manageSalaryManage;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String checkSalaryStandard()
	{
		System.out.println("-------salaryStandardAction.checkSalaryStandard--------");
		List<ManagePositionSalary> lst1 = manageSalaryManage.findAllPositionSalary();
		List<ManagePaylevelSalary> lst2 = manageSalaryManage.findAllPayLevelSalary();
		Map session = ActionContext.getContext().getSession();
		session.put("managepositionsalary", lst1);
		session.put("managepaylevelsalary", lst2);
		return "success";
	}
	
	public String modifyPosSalaryStandard()
	{
		System.out.println("-------salaryStandardAction.modifyPosSalaryStandard--------");
		System.out.println(type);
		System.out.println(level);
		if(type.equals("pro")) {
		ProfessionalPositionSalary professionalPositionSalary  = new ProfessionalPositionSalary();
		professionalPositionSalary  = profSalaryManage.findProfPosSalByLevel(level);
		professionalPositionSalary.setPosition(position);
		professionalPositionSalary.setLevel(level);
		professionalPositionSalary.setSalaryStandard(salaryStandard);
		professionalPositionSalary.setStartPayLevel(startPayLevel);
		profSalaryManage.modifyProfPosSal(professionalPositionSalary);
		return getAllSalaryStandard();
		}
		else if (type.equals("man")) {
			ManagePositionSalary managePositionSalary = new ManagePositionSalary();
			managePositionSalary = manageSalaryManage.findManPosSalByLevel(level);
			managePositionSalary.setPosition(position);
			managePositionSalary.setLevel(level);
			managePositionSalary.setSalaryStandard(salaryStandard);
			managePositionSalary.setStartPayLevel(startPayLevel);
			manageSalaryManage.modifyManPaySal(managePaylevelSalary);
			return getAllSalaryStandard();
		}
		else if (type.equals("worker")) {
			WorkerPositionSalary workerPositionSalary = new WorkerPositionSalary();
			workerPositionSalary = workerSalaryManage.findWorkerPosSalByLevel(level);
			workerPositionSalary.setPosition(position);
			workerPositionSalary.setSalaryStandard(salaryStandard);
			workerPositionSalary.setStartPayLevel(startPayLevel);
			workerSalaryManage.modifyWorkerPosSal(workerPositionSalary);
			return getAllSalaryStandard();
		}
		
		return "false";
	}
	
	public String modifyLevSalaryStandard()
	{
		System.out.println("-------salaryStandardAction.modifyLevSalaryStandard--------");
		System.out.println(type);
		System.out.println(payLevel);
		if(type.equals("pro")) {
			ProfessionalPaylevelSalary professionalPaylevelSalary  = new ProfessionalPaylevelSalary();
			professionalPaylevelSalary = profSalaryManage.findProfPaySalByPayLevel(payLevel);
			professionalPaylevelSalary.setPayLevel(payLevel);
			professionalPaylevelSalary.setSalaryStandard(payLevelSalaryStandard);
			profSalaryManage.modifyProfPaySal(professionalPaylevelSalary);
			return getAllSalaryStandard();
			}
			else if (type.equals("man")) {
				ManagePaylevelSalary managePaylevelSalary = new ManagePaylevelSalary();
				managePaylevelSalary = manageSalaryManage.findManPaySalByPayLevel(payLevel);
				managePaylevelSalary.setPayLevel(payLevel);
				managePaylevelSalary.setSalaryStandard(payLevelSalaryStandard);
				manageSalaryManage.modifyManPaySal(managePaylevelSalary);
				return getAllSalaryStandard();
			}
			else if (type.equals("worker")) {
				WorkerPaylevelSalary workerPaylevelSalary = new WorkerPaylevelSalary();
				workerPaylevelSalary = workerSalaryManage.findWorkerPaySalByPayLevel(payLevel);
				workerPaylevelSalary.setPayLevel(payLevel);
				workerPaylevelSalary.setSalaryStandard(payLevelSalaryStandard);
				workerSalaryManage.modifyWorkerPaySal(workerPaylevelSalary);
				return getAllSalaryStandard();
			}
		return "fail";
	}
	
	public String getAllSalaryStandard()  {
		System.out.println("GetAllSalary");

		ActionContext.getContext().getSession().put("manList",manageSalaryManage.findAllPositionSalary());
		ActionContext.getContext().getSession().put("proList",profSalaryManage.findAllPositionSalary());
		ActionContext.getContext().getSession().put("workerList", workerSalaryManage.findAllPositionSalary());
		ActionContext.getContext().getSession().put("manPayLevelList",manageSalaryManage.findAllPayLevelSalary());
		ActionContext.getContext().getSession().put("proPayLevelList",profSalaryManage.findAllPayLevelSalary());
		ActionContext.getContext().getSession().put("workerPayLevelList", workerSalaryManage.findAllPayLevelSalary());
		System.out.println("Add All");
		return "success";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getChangeInfo() throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = ActionContext.getContext().getSession();
		tableName = request.getParameter("tableName");
		session.put("tableName", tableName);
		type = request.getParameter("type");
		session.put("type", type);
		System.out.print(tableName);
		if(tableName.equals("posSalary")) {
			session.put("position", new String(request.getParameter("position").getBytes("ISO8859-1"),"UTF-8"));
			session.put("level", Integer.parseInt(request.getParameter("level")));
			session.put("salaryStandard", Integer.parseInt(request.getParameter("salaryStandard")));
			session.put("startPayLevel", Integer.parseInt(request.getParameter("startPayLevel")));
			return "success";
		}
		else if ("payLevel".equals(tableName)) {
			session.put("payLevel", Integer.parseInt(request.getParameter("payLevel")));
			session.put("payLevelSalaryStandard", Integer.parseInt(request.getParameter("payLevelSalaryStandard")));
			return "success";
		}			
			
		return "fail";
		
	}
}
