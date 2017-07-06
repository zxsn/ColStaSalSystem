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
public class SpecialRecoveryExport {
	Integer eid;
	String name;
	String department;
	String reason;
	Date date;
	
	public SpecialRecoveryExport(Integer eid,String name,String department,String reason,Date date){
		this.eid=eid;
		this.name=name;
		this.department=department;
		this.reason=reason;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
