package com.xin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xin.dao.ITitleChangeDao;
import com.xin.bean.TitleChange;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class TitleChangeDaoImp implements ITitleChangeDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addTitleChange(TitleChange titleChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(titleChange);
	}

	@Override
	public void deleteTitleChange(TitleChange titleChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(titleChange);
	}

	@Override
	public void modifyTitleChange(TitleChange titleChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(titleChange);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TitleChange> findTitleChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from TitleChange where eId = ?");
		query.setString(0, eId.toString());	
		return (List<TitleChange>)query.list();
	}

}
