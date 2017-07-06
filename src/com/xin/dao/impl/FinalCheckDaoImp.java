package com.xin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xin.dao.IFinalCheckDao;
import com.xin.bean.FinalCheck;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class FinalCheckDaoImp implements IFinalCheckDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addFinalCheck(FinalCheck finalCheck) {
		getSession().clear();
		getSession().save(finalCheck);
	}

	@Override
	public void deleteFinalCheck(FinalCheck finalCheck) {
		getSession().clear();
		getSession().delete(finalCheck);
	}

	@Override
	public void modifyFinalCheck(FinalCheck finalCheck) {
		getSession().clear();
		getSession().update(finalCheck);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FinalCheck> findFinalCheckByEId(Integer eId) {
		Query query = (Query)getSession().createQuery("from FinalCheck where eId = ?");
		query.setString(0, eId.toString());	
		return (List<FinalCheck>)query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FinalCheck> findFinalChecksByResult(String result) {
		Query query = (Query) getSession().createCriteria("from FinalCheck where checkResult = ?");
		query.setString(0, result);
		return (List<FinalCheck>)query.list();
	}

}
