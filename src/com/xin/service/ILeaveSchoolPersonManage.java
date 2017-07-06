package com.xin.service;

import java.util.List;

import com.xin.bean.LeaveSchoolPerson;
/**
 * 
    * @ClassName: ILeaveSchoolPersonManage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface ILeaveSchoolPersonManage {
	public void addLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson);
	public void deleteLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson);
	public void modifyLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson);
	public LeaveSchoolPerson findLeaveSchoolPersonByEId(Integer eId);
	public List<LeaveSchoolPerson> findLeaveSchoolPersonsList();
}
