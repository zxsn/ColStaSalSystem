package com.xin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xin.dao.ILeaveSchoolPersonDao;
import com.xin.bean.LeaveSchoolPerson;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class LeaveSchoolPersonDaoImp implements ILeaveSchoolPersonDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(leaveSchoolPerson);
	}

	@Override
	public void deleteLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(leaveSchoolPerson);
	}

	@Override
	public void modifyLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(leaveSchoolPerson);
	}

	@Override
	public LeaveSchoolPerson findLeaveSchoolPersonByEId(Integer eId) {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from LeaveSchoolPerson where eId = ?");
		query.setString(0, eId.toString());	
		return (LeaveSchoolPerson)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LeaveSchoolPerson> findLeaveSchoolPersonsList() {
		Query query = (Query)getSession().createQuery("from LeaveSchoolPerson");
		return (List<LeaveSchoolPerson>)query.list();
	}
}
