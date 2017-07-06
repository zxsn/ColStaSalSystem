package com.xin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xin.dao.ISpecialSalaryChangeDao;
import com.xin.bean.SpecialSalaryChange;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class SpecialSalaryChangeDaoImp implements ISpecialSalaryChangeDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addSpecialSalaryChange(SpecialSalaryChange specialSalaryChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(specialSalaryChange);
	}

	@Override
	public void deleteSpecialSalaryChange(SpecialSalaryChange specialSalaryChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(specialSalaryChange);
	}

	@Override
	public void modifySpecialSalaryChange(SpecialSalaryChange specialSalaryChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(specialSalaryChange);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SpecialSalaryChange> findSpecialSalaryChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from SpecialSalaryChange where eId = ?");
		query.setString(0, eId.toString());	
		return (List<SpecialSalaryChange>)query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SpecialSalaryChange> findAllSpecialSalaryChange() {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from SpecialSalaryChange");
		return (List<SpecialSalaryChange>)query.list();
	}

}
