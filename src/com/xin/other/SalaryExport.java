package com.xin.other;

import java.util.Date;

/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class SalaryExport {
	Integer eid;
	String name;
	String department;
	Integer positionSalary;
	Integer levelSalary;
	Integer salary;
	Date date;
	
	public SalaryExport(Integer eid,String name,String department,Integer positionSalary,Integer levelSalary,Integer salary,Date date){
		this.eid=eid;
		this.name=name;
		this.department=department;
		this.positionSalary=positionSalary;
		this.levelSalary=levelSalary;
		this.salary=salary;
		this.date=date;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getPositionSalary() {
		return positionSalary;
	}
	public void setPositionSalary(Integer positionSalary) {
		this.positionSalary = positionSalary;
	}
	public Integer getLevelSalary() {
		return levelSalary;
	}
	public void setLevelSalary(Integer levelSalary) {
		this.levelSalary = levelSalary;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
