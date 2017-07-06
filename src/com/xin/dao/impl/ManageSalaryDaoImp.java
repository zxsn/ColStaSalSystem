package com.xin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xin.dao.IManageSalaryDao;
import com.xin.bean.ManagePaylevelSalary;
import com.xin.bean.ManagePositionSalary;
import com.xin.bean.ManageSalaryChange;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class ManageSalaryDaoImp implements IManageSalaryDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addManPaySal(ManagePaylevelSalary manPaylevelSalary) {
		getSession().save(manPaylevelSalary);
	}
	@Override
	public void modifyManPaySal(ManagePaylevelSalary manPaylevelSalary) {
		getSession().update(manPaylevelSalary);
	}
	@Override
	public void deleteManPaySal(ManagePaylevelSalary manPaylevelSalary) {
		getSession().delete(manPaylevelSalary);
	}
	@Override
	public ManagePaylevelSalary findManPaySalByPayLevel(Integer payLevel) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from ManagePaylevelSalary as m where m.payLevel = ?");
		query.setString(0,payLevel.toString());
		ManagePaylevelSalary m = (ManagePaylevelSalary)query.uniqueResult();
		return m;
	}

	
	@Override
	public void addManPosSal(ManagePositionSalary managePositionSalary) {

		getSession().save(managePositionSalary);
	}
	@Override
	public void modifyManPosSal(ManagePositionSalary managePositionSalary) {
		getSession().clear();
		System.out.println("ManagePositioinSalary"+managePositionSalary.getStartPayLevel());
		getSession().update(managePositionSalary);
	}
	@Override
	public void deleteManPosSal(ManagePositionSalary managePositionSalary) {

		getSession().delete(managePositionSalary);
	}
	@Override
	public ManagePositionSalary findManPosSalByLevel(Integer level) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from ManagePositionSalary as m where m.level = ?");
		query.setString(0,level.toString());
		ManagePositionSalary m = (ManagePositionSalary)query.uniqueResult();
		return m;
	}

	
	@Override
	public void addManSalCha(ManageSalaryChange manageSalaryChange) {
		// TODO Auto-generated method stub
		getSession().save(manageSalaryChange);
	}
	@Override
	public void modifyManSalCha(ManageSalaryChange manageSalaryChange) {
		// TODO Auto-generated method stub
		getSession().update(manageSalaryChange);
	}
	@Override
	public void deleteManSalCha(ManageSalaryChange manageSalaryChange) {
		// TODO Auto-generated method stub
		getSession().delete(manageSalaryChange);
	}

	@Override
	public ManageSalaryChange findManSalChaByLevel(Integer level,Integer off,Integer cha) {
		// TODO Auto-generated method stub
		//System.out.println("start");
		String hql="from ManageSalaryChange where ";
		hql=hql+"positionLevel = ?"+" and ";
		hql=hql+"lowBoundOfOfficeYear<=?"+" and ";
		hql=hql+"upperBoundOfOfficeYear>=?"+" and ";
		hql=hql+"lowBoundOfChangeYear<=?"+" and ";
		hql=hql+"upperBoundOfChangeYear>=?";
		Query query = getSession().createQuery(hql);
		query.setString(0,level.toString());
		query.setString(1,off.toString());
		query.setString(2,off.toString());
		query.setString(3,cha.toString());
		query.setString(4,cha.toString());
		ManageSalaryChange m = (ManageSalaryChange)query.uniqueResult();
		//System.out.println(m.getId());
		return m;		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ManagePaylevelSalary> findAllPayLevelSalary() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from ManagePaylevelSalary");
		List<ManagePaylevelSalary> listPay = query.list();
		return listPay;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<ManagePositionSalary> findAllPositionSalary() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from ManagePositionSalary");
		List<ManagePositionSalary> listPos = query.list();
		return listPos;
	}
}
