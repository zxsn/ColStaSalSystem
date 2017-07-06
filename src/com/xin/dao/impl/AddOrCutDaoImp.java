package com.xin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xin.dao.IAddOrCutDao;
import com.xin.bean.AddOrCut;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class AddOrCutDaoImp implements IAddOrCutDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addAddOrCut(AddOrCut addOrCut) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(addOrCut);
	}

	@Override
	public void deleteAddOrCut(AddOrCut addOrCut) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(addOrCut);
	}

	@Override
	public void modifyAddOrCut(AddOrCut addOrCut) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(addOrCut);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AddOrCut> findAddOrCutByEId(Integer eId) {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from AddOrCut where eId = ?");
		query.setString(0, eId.toString());	
		return ( List<AddOrCut>)query.list();
	}

}
