package com.xin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xin.dao.IWorkerSalaryDao;
import com.xin.bean.WorkerPaylevelSalary;
import com.xin.bean.WorkerPositionSalary;
import com.xin.bean.WorkerSalaryChange;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class WorkerSalaryDaoImp implements IWorkerSalaryDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addWorkerPaySal(WorkerPaylevelSalary workerPaylevelSalary) {
		// TODO Auto-generated method stub
		getSession().save(workerPaylevelSalary);
	}

	@Override
	public void modifyWorkerPaySal(WorkerPaylevelSalary workerPaylevelSalary) {
		// TODO Auto-generated method stub
		getSession().update(workerPaylevelSalary);
	}

	@Override
	public void deleteWorkerPaySal(WorkerPaylevelSalary workerPaylevelSalary) {
		// TODO Auto-generated method stub
		getSession().delete(workerPaylevelSalary);
	}

	@Override
	public WorkerPaylevelSalary findWorkerPaySalByPayLevel(Integer payLevel) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from WorkerPaylevelSalary as w where w.payLevel = ?");
		query.setString(0,payLevel.toString());
		WorkerPaylevelSalary w = (WorkerPaylevelSalary)query.uniqueResult();
		return w;
	}

	@Override
	public void addWorkerPosSal(WorkerPositionSalary workerPositionSalary) {
		// TODO Auto-generated method stub
		getSession().save(workerPositionSalary);
	}

	@Override
	public void modifyWorkerPosSal(WorkerPositionSalary workerPositionSalary) {
		// TODO Auto-generated method stub
		getSession().update(workerPositionSalary);
	}

	@Override
	public void deleteWorkerPosSal(WorkerPositionSalary workerPositionSalary) {
		// TODO Auto-generated method stub
		getSession().delete(workerPositionSalary);
	}

	@Override
	public WorkerPositionSalary findWorkerPosSalByLevel(Integer level) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from WorkerPositionSalary as w where w.level = ?");
		query.setString(0,level.toString());
		WorkerPositionSalary w = (WorkerPositionSalary)query.uniqueResult();
		return w;
	}

	@Override
	public void addWorkerSalCha(WorkerSalaryChange workerSalaryChange) {
		// TODO Auto-generated method stub
		getSession().save(workerSalaryChange);
	}

	@Override
	public void modifyWorkerSalCha(WorkerSalaryChange workerSalaryChange) {
		// TODO Auto-generated method stub
		getSession().update(workerSalaryChange);
	}

	@Override
	public void deleteWorkerSalCha(WorkerSalaryChange workerSalaryChange) {
		// TODO Auto-generated method stub
		getSession().delete(workerSalaryChange);
	}

	@Override
	public WorkerSalaryChange findWorkerSalChaByLevel(Integer level,
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
		WorkerSalaryChange w = (WorkerSalaryChange)query.uniqueResult();
		//System.out.println(m.getId());
		return w;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkerPaylevelSalary> findAllPayLevelSalary() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from WorkerPaylevelSalary");
		List<WorkerPaylevelSalary> listPay = query.list();
		return listPay;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkerPositionSalary> findAllPositionSalary() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from WorkerPositionSalary");
		List<WorkerPositionSalary> listPos = query.list();
		return listPos;
	}
}
