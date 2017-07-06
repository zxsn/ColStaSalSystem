package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.ILeaveSchoolPersonDao;
import com.xin.bean.LeaveSchoolPerson;
import com.xin.service.ILeaveSchoolPersonManage;
/**
 * 
    * @ClassName: LeaveSchoolPersonManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class LeaveSchoolPersonManageImp implements ILeaveSchoolPersonManage{
	@Resource
	private ILeaveSchoolPersonDao iLeaveSchoolPersonDao;

	@Override
	public void addLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson) {
		// TODO Auto-generated method stub
		iLeaveSchoolPersonDao.addLeaveSchoolPerson(leaveSchoolPerson);
	}

	@Override
	public void deleteLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson) {
		// TODO Auto-generated method stub
		iLeaveSchoolPersonDao.deleteLeaveSchoolPerson(leaveSchoolPerson);
	}

	@Override
	public void modifyLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson) {
		// TODO Auto-generated method stub
		iLeaveSchoolPersonDao.modifyLeaveSchoolPerson(leaveSchoolPerson);
	}

	@Override
	public LeaveSchoolPerson findLeaveSchoolPersonByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iLeaveSchoolPersonDao.findLeaveSchoolPersonByEId(eId);
	}
	
	@Override
	public List<LeaveSchoolPerson> findLeaveSchoolPersonsList() {
		return iLeaveSchoolPersonDao.findLeaveSchoolPersonsList();
	}

}
