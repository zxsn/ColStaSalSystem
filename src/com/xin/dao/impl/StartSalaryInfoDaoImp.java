package com.xin.dao.impl;

import java.util.List;

import org.hibernate.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xin.dao.IStartSalaryInfoDao;
import com.xin.bean.StartSalaryInfo;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class StartSalaryInfoDaoImp implements IStartSalaryInfoDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addStartSalaryInfo(StartSalaryInfo startSalaryInfo) {
		getSession().save(startSalaryInfo);
	}

	@Override
	public void modifyStartSalaryInfo(StartSalaryInfo startSalaryInfo) {
		getSession().clear();
		getSession().update(startSalaryInfo);
	}

	@Override
	public void deleteStartSalaryInfo(StartSalaryInfo startSalaryInfo) {
		getSession().clear();
		getSession().update(startSalaryInfo);
	}

	@Override
	public StartSalaryInfo findStartSalaryInfoByEId(Integer eid) {
		Query query = (Query)getSession().createQuery("from StartSalaryInfo as s where s.eid = ?");
		query.setString(0, eid.toString());
		return (StartSalaryInfo)query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StartSalaryInfo> getAllStartSalaryInfo() {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from StartSalaryInfo");
		//System.out.println(query.list().size());
		return (List<StartSalaryInfo>)query.list();
	}
}
