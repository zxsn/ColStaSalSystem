package com.xin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xin.dao.IProfSalaryDao;
import com.xin.bean.ProfessionalPaylevelSalary;
import com.xin.bean.ProfessionalPositionSalary;
import com.xin.bean.ProfessionalSalaryChange;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class ProfSalaryDaoImp implements IProfSalaryDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addProfPaySal(ProfessionalPaylevelSalary profPaylevelSalary) {
		// TODO Auto-generated method stub
		getSession().save(profPaylevelSalary);
	}

	@Override
	public void modifyProfPaySal(ProfessionalPaylevelSalary profPaylevelSalary) {
		// TODO Auto-generated method stub
		getSession().update(profPaylevelSalary);
	}

	@Override
	public void deleteProfPaySal(ProfessionalPaylevelSalary profPaylevelSalary) {
		// TODO Auto-generated method stub
		getSession().delete(profPaylevelSalary);
	}

	@Override
	public ProfessionalPaylevelSalary findProfPaySalByPayLevel(Integer payLevel) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from ProfessionalPaylevelSalary as p where p.payLevel = ?");
		query.setString(0,payLevel.toString());
		ProfessionalPaylevelSalary p = (ProfessionalPaylevelSalary)query.uniqueResult();
		return p;
	}

	@Override
	public void addProfPosSal(ProfessionalPositionSalary profPositionSalary) {
		// TODO Auto-generated method stub
		getSession().save(profPositionSalary);
	}

	@Override
	public void modifyProfPosSal(ProfessionalPositionSalary profPositionSalary) {
		// TODO Auto-generated method stub
		getSession().update(profPositionSalary);
	}

	@Override
	public void deleteProfPosSal(ProfessionalPositionSalary profPositionSalary) {
		// TODO Auto-generated method stub
		getSession().delete(profPositionSalary);
	}

	@Override
	public ProfessionalPositionSalary findProfPosSalByLevel(Integer level) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from ProfessionalPositionSalary as p where p.level = ?");
		query.setString(0,level.toString());
		ProfessionalPositionSalary p = (ProfessionalPositionSalary)query.uniqueResult();
		return p;
	}

	@Override
	public void addProfSalCha(ProfessionalSalaryChange profSalaryChange) {
		// TODO Auto-generated method stub
		getSession().save(profSalaryChange);
	}

	@Override
	public void modifyProfSalCha(ProfessionalSalaryChange profSalaryChange) {
		// TODO Auto-generated method stub
		getSession().update(profSalaryChange);
	}

	@Override
	public void deleteProfSalCha(ProfessionalSalaryChange profSalaryChange) {
		// TODO Auto-generated method stub
		getSession().delete(profSalaryChange);
	}

	@Override
	public ProfessionalSalaryChange findProfSalChaByLevel(Integer level,
			Integer off, Integer cha) {
		// TODO Auto-generated method stub
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
		ProfessionalSalaryChange p = (ProfessionalSalaryChange)query.uniqueResult();
		//System.out.println(m.getId());
		return p;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfessionalPaylevelSalary> findAllPayLevelSalary() {
		// TODO 专业技术人员薪级工资表
		Query query = getSession().createQuery("from ProfessionalPaylevelSalary");
		List<ProfessionalPaylevelSalary> listPay = query.list();
		return listPay;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfessionalPositionSalary> findAllPositionSalary() {
		// TODO 专业技术人员岗位工资表
		Query query = getSession().createQuery("from ProfessionalPositionSalary");
		List<ProfessionalPositionSalary> listPos = query.list();
		return listPos;
	}

}
