package com.xin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xin.dao.IFinalBonusDao;
import com.xin.bean.FinalBonus;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class FinalBonusDaoImp implements IFinalBonusDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addFinalBonus(FinalBonus finalBonus) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(finalBonus);
	}

	@Override
	public void deleteFinalBonus(FinalBonus finalBonus) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(finalBonus);
	}

	@Override
	public void modifyFinalBonus(FinalBonus finalBonus) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(finalBonus);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FinalBonus> findFinalBonusByEId(Integer eId) {
		Query query = (Query)getSession().createQuery("from FinalBonus where eId = ?");
		query.setString(0, eId.toString());	
		return (List<FinalBonus>)query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FinalBonus> findFinalBonusByDoubleBonusType(
			String doubleBonusType) {
		Query query = (Query)getSession().createQuery("from FinalBonus where  doubleSalaryType = ?");
		query.setString(0, doubleBonusType);	
		return (List<FinalBonus>)query.list();
	}

}
