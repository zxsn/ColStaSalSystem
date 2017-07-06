package com.xin.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.xin.bean.Employee;
import com.xin.bean.Salary;
import com.xin.service.IEmployeeManage;
import com.xin.service.ISalaryManage;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class SalaryQuery {
	private List<Salary> salaryList;
	private Integer eid;
	private String name;
	private Date startDate;
	private Date endDate;
	private Integer totalPosition,totalLevel,totalAmount;
	private Integer averagePosition,averageLevel,averageAmount;
	
	@Resource
	private IEmployeeManage iEmployeeManage;
	
	@Resource 
	private ISalaryManage iSalaryManage;
	
	public String querySalary(){
		totalPosition=0;
		totalLevel=0;
		totalAmount=0;
		System.out.println("aa");
		salaryList=new ArrayList<Salary>();
		List<Salary> templist=new ArrayList<Salary>();
		List<Employee> employList = iEmployeeManage.findEmployeesByName(name);
		System.out.println(employList.size());
		if(eid==null){		
			if(employList!=null){
				for(int j=0;j<employList.size();j++){
					templist=iSalaryManage.findSalaryByEId(employList.get(j).getId());
					System.out.println(templist.size());
					for(int i=0;i<templist.size();i++){
						if((endDate==null || (templist.get(i).getTime().getTime()) < (endDate.getTime())) && 
								   (startDate==null || (templist.get(i).getTime().getTime()) > (startDate.getTime())))
							salaryList.add(templist.get(i));
					}
				}
			}
		}
		else{
			templist=iSalaryManage.findSalaryByEId(eid);
			System.out.println("hehe"+eid);
			Employee emploee=iEmployeeManage.findEmployeeById(eid);
			if(name.isEmpty() || emploee.getName().equals(name)){
				for(int i=0;i<templist.size();i++){
					if((endDate==null || (templist.get(i).getTime().getTime()) < (endDate.getTime())) && 
					   (startDate==null || (templist.get(i).getTime().getTime()) > (startDate.getTime())))
						salaryList.add(templist.get(i));System.out.println("wocao");
				}
				System.out.println(templist.size());
			}
		}
		
		ActionContext.getContext().getSession().put("salaryList", salaryList);
		
		if(salaryList.isEmpty())  {
			ActionContext.getContext().getSession().put("totalPosition", 0);
			ActionContext.getContext().getSession().put("totalLevel", 0);
			ActionContext.getContext().getSession().put("totalAmount", 0);
			ActionContext.getContext().getSession().put("averageAmount", 0);
			ActionContext.getContext().getSession().put("averageLevel", 0);
			ActionContext.getContext().getSession().put("averagePosition", 0);
			return "success";
		}
		
		
		for(int i=0;i<salaryList.size();i++){
			totalPosition+=salaryList.get(i).getPositionSalary();
			totalLevel+=salaryList.get(i).getLevelSalary();
			totalAmount+=salaryList.get(i).getTotleSalary();
		}
		averageAmount=totalAmount/salaryList.size();
		averageLevel=totalLevel/salaryList.size();
		averagePosition=totalPosition/salaryList.size();
		
		ActionContext.getContext().getSession().put("totalPosition", totalPosition);
		ActionContext.getContext().getSession().put("totalLevel", totalLevel);
		ActionContext.getContext().getSession().put("totalAmount", totalAmount);
		ActionContext.getContext().getSession().put("averageAmount", averageAmount);
		ActionContext.getContext().getSession().put("averageLevel", averageLevel);
		ActionContext.getContext().getSession().put("averagePosition", averagePosition);
		
		return Action.SUCCESS;
	}
	
	public String userSalaryQuery(){
		totalPosition=0;
		totalLevel=0;
		totalAmount=0;

		eid = Integer.parseInt(ActionContext.getContext().getSession().get("user.id").toString());
		
		salaryList=new ArrayList<Salary>();
		List<Salary> templist=new ArrayList<Salary>();

		templist=iSalaryManage.findSalaryByEId(eid);
		//System.out.println("hehe"+eid);

		System.out.println(templist.size());
		System.out.println(endDate);
		for(int i=0;i<templist.size();i++){
			if((endDate==null || (templist.get(i).getTime().getTime()) < (endDate.getTime())) && 
			   (startDate==null || (templist.get(i).getTime().getTime()) > (startDate.getTime())))
				salaryList.add(templist.get(i));
		}
		//System.out.println(templist.size());
	
		ActionContext.getContext().getSession().put("salaryList", salaryList);
		
		if(salaryList.isEmpty())  {
			ActionContext.getContext().getSession().put("totalPosition", 0);
			ActionContext.getContext().getSession().put("totalLevel", 0);
			ActionContext.getContext().getSession().put("totalAmount", 0);
			ActionContext.getContext().getSession().put("averageAmount", 0);
			ActionContext.getContext().getSession().put("averageLevel", 0);
			ActionContext.getContext().getSession().put("averagePosition", 0);
			return "success";
		}
	
		for(int i=0;i<salaryList.size();i++){
			totalPosition+=salaryList.get(i).getPositionSalary();
			totalLevel+=salaryList.get(i).getLevelSalary();
			totalAmount+=salaryList.get(i).getTotleSalary();
		}
		averageAmount=totalAmount/salaryList.size();
		averageLevel=totalLevel/salaryList.size();
		averagePosition=totalPosition/salaryList.size();
		
		ActionContext.getContext().getSession().put("totalPosition", totalPosition);
		ActionContext.getContext().getSession().put("totalLevel", totalLevel);
		ActionContext.getContext().getSession().put("totalAmount", totalAmount);
		ActionContext.getContext().getSession().put("averageAmount", averageAmount);
		ActionContext.getContext().getSession().put("averageLevel", averageLevel);
		ActionContext.getContext().getSession().put("averagePosition", averagePosition);
		System.out.println(templist.size());
		
		return Action.SUCCESS;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public IEmployeeManage getiEmployeeManage() {
		return iEmployeeManage;
	}

	public void setiEmployeeManage(IEmployeeManage iEmployeeManage) {
		this.iEmployeeManage = iEmployeeManage;
	}

	public ISalaryManage getiSalaryManage() {
		return iSalaryManage;
	}

	public void setiSalaryManage(ISalaryManage iSalaryManage) {
		this.iSalaryManage = iSalaryManage;
	}
 }
