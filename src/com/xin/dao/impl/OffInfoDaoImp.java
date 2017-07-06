package com.xin.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.*;

import com.xin.dao.IOffInfoDao;
import com.xin.bean.OffInfo;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class OffInfoDaoImp implements IOffInfoDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addOffInfo(OffInfo offInfo) {
		getSession().save(offInfo);
	}

	@Override
	public void deleteOffInfo(OffInfo offInfo) {
		getSession().clear();
		getSession().delete(offInfo);

	}

	@Override
	public void modifyOffInfo(OffInfo offInfo) {
		getSession().clear();
		getSession().update(offInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OffInfo> findOffInfoByEId(Integer eid) {
		Query query = (Query)getSession().createQuery("from OffInfo where eid= ?");
		query.setInteger(0, eid);	
		return (List<OffInfo>)query.list();
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<OffInfo> findOffInfoThisYear() {
		Query query = (Query)getSession().createQuery("from OffInfo where startDate between ? and ? or endDate between ? and ?");
		Date yearStart = new Date(new Date().getYear(), 1, 1);
		Date yearEnd = new Date(new Date().getYear(), 12, 31);
		query.setDate(0, yearStart);
		query.setDate(1, yearEnd);
		query.setDate(2, yearStart);
		query.setDate(3, yearEnd);
		return (List<OffInfo>)query.list();
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<OffInfo> findOffInfoThisYearByEId(Integer eId) {
		Query query = (Query)getSession().createQuery("from OffInfo where eid=? and (startDate between ? and ? or endDate between ? and ?)");
		Date yearStart = new Date(new Date().getYear(), 0, 1);
		Date yearEnd = new Date(new Date().getYear(), 11, 31);
		query.setDate(1, yearStart);
		query.setDate(2, yearEnd);
		query.setDate(3, yearStart);
		query.setDate(4, yearEnd);
		query.setInteger(0, eId);
		return (List<OffInfo>)query.list();
	}

}
