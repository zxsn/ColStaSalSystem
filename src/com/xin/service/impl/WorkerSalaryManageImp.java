package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.IWorkerSalaryDao;
import com.xin.bean.WorkerPaylevelSalary;
import com.xin.bean.WorkerPositionSalary;
import com.xin.bean.WorkerSalaryChange;
import com.xin.service.IWorkerSalaryManage;
/**
 * 
    * @ClassName: WorkerSalaryManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class WorkerSalaryManageImp implements IWorkerSalaryManage{
	private WorkerPositionSalary workerPositionSalary;
	private WorkerPaylevelSalary workerPaylevelSalary;
	private WorkerSalaryChange workerSalaryChange;
	
	@Resource
	private IWorkerSalaryDao IWorkerSalaryDao;
	
	public WorkerPositionSalary getWorkerPositionSalary() {
		return workerPositionSalary;
	}

	public void setWorkerPositionSalary(WorkerPositionSalary WorkerPositionSalary) {
		this.workerPositionSalary = WorkerPositionSalary;
	}

	public WorkerSalaryChange getWorkerSalaryChange() {
		return workerSalaryChange;
	}

	public void setWorkerSalaryChange(WorkerSalaryChange WorkerSalaryChange) {
		this.workerSalaryChange = WorkerSalaryChange;
	}

	public WorkerPaylevelSalary getWorkerPaylevelSalary() {
		return workerPaylevelSalary;
	}

	public void setWorkerPaylevelSalary(WorkerPaylevelSalary WorkerPaylevelSalary) {
		this.workerPaylevelSalary = WorkerPaylevelSalary;
	}

	public IWorkerSalaryDao getWorkerSalaryDao() {
		return IWorkerSalaryDao;
	}

	public void setWorkerSalaryDao(IWorkerSalaryDao WorkerSalaryDao) {
		this.IWorkerSalaryDao = WorkerSalaryDao;
	}
	
	@Override
	public void addWorkerPaySal(WorkerPaylevelSalary WorkerPaylevelSalary) {
		// TODO Auto-generated method stub
		IWorkerSalaryDao.addWorkerPaySal(WorkerPaylevelSalary);
	}
	
	@Override
	public void modifyWorkerPaySal(WorkerPaylevelSalary WorkerPaylevelSalary) {
		// TODO Auto-generated method stub
		setWorkerPaySalByPayLevel(WorkerPaylevelSalary.getPayLevel());
		getWorkerPaylevelSalary().setSalaryStandard(WorkerPaylevelSalary.getSalaryStandard());
		IWorkerSalaryDao.modifyWorkerPaySal(getWorkerPaylevelSalary());
	}

	@Override
	public void deleteWorkerPaySal() {
		// TODO Auto-generated method stub
		IWorkerSalaryDao.deleteWorkerPaySal(getWorkerPaylevelSalary());
	}
	
	@Override
	public WorkerPositionSalary findWorPosSalByLevel(Integer level) {
		this.workerPositionSalary = IWorkerSalaryDao.findWorkerPosSalByLevel(level);
		return this.workerPositionSalary;
	}

	@Override
	public void setWorkerPaySalByPayLevel(Integer payLevel) {
		// TODO Auto-generated method stub
		this.workerPaylevelSalary=IWorkerSalaryDao.findWorkerPaySalByPayLevel(payLevel);
	}

	@Override
	public void addWorkerPosSal(WorkerPositionSalary WorkerPositionSalary) {
		// TODO Auto-generated method stub
		IWorkerSalaryDao.addWorkerPosSal(WorkerPositionSalary);
	}

	@Override
	public void modifyWorkerPosSal(WorkerPositionSalary WorkerPositionSalary) {
		// TODO Auto-generated method stub
		setWorkerPosSalByLevel(WorkerPositionSalary.getLevel());
		getWorkerPositionSalary().setSalaryStandard(WorkerPositionSalary.getSalaryStandard());
		getWorkerPositionSalary().setPosition(WorkerPositionSalary.getPosition());
		IWorkerSalaryDao.modifyWorkerPosSal(getWorkerPositionSalary());
	}

	@Override
	public void deleteWorkerPosSal() {
		// TODO Auto-generated method stub
		IWorkerSalaryDao.deleteWorkerPosSal(getWorkerPositionSalary());
	}

	@Override
	public void setWorkerPosSalByLevel(Integer level) {
		// TODO Auto-generated method stub
		this.workerPositionSalary=IWorkerSalaryDao.findWorkerPosSalByLevel(level);
	}

	@Override
	public void addWorkerSalCha(WorkerSalaryChange WorkerSalaryChange) {
		// TODO Auto-generated method stub
		IWorkerSalaryDao.addWorkerSalCha(WorkerSalaryChange);
	}

	@Override
	public void modifyWorkerSalCha(WorkerSalaryChange WorkerSalaryChange) {
		// TODO Auto-generated method stub
		setWorkerSalChaByLevel(WorkerSalaryChange.getPositionLevel(), WorkerSalaryChange.getUpperBoundOfChangeYear(), WorkerSalaryChange.getUpperBoundOfChangeYear());
		getWorkerSalaryChange().setPayLevel(WorkerSalaryChange.getPayLevel());
		IWorkerSalaryDao.modifyWorkerSalCha(WorkerSalaryChange);
	}

	@Override
	public void deleteWorkerSalCha() {
		// TODO Auto-generated method stub
		IWorkerSalaryDao.deleteWorkerSalCha(workerSalaryChange);
	}

	@Override
	public void setWorkerSalChaByLevel(Integer level,Integer off,Integer cha) {
		// TODO Auto-generated method stub
		this.workerSalaryChange=IWorkerSalaryDao.findWorkerSalChaByLevel(level,off,cha);
	}

	@Override
	public Integer getSalary() {
		// TODO Auto-generated method stub
		return workerPaylevelSalary.getSalaryStandard()+workerPositionSalary.getSalaryStandard();
	}

	@Override
	public void setAllManage(Integer level,Integer off,Integer cha) {
		//System.out.println(level);
		// TODO Auto-generated method stub
		setWorkerSalChaByLevel(level,off,cha);
		System.out.println(getWorkerSalaryChange().getPayLevel());
		setWorkerPaySalByPayLevel(getWorkerSalaryChange().getPayLevel());
		setWorkerPosSalByLevel(level);
	}

	@Override
	public List<WorkerPaylevelSalary> findAllPayLevelSalary() {
		return IWorkerSalaryDao.findAllPayLevelSalary();
	}

	@Override
	public List<WorkerPositionSalary> findAllPositionSalary() {
		// TODO Auto-generated method stub
		return IWorkerSalaryDao.findAllPositionSalary();
	}

	@Override
	public Integer getPayLevel(Integer level, Integer off, Integer cha) {
		// TODO Auto-generated method stub
		setAllManage(level, off, cha);
		
		return getWorkerSalaryChange().getPayLevel();
	}

	@Override
	public WorkerPositionSalary findWorkerPosSalByLevel(Integer level) {
		return  IWorkerSalaryDao.findWorkerPosSalByLevel(level);
		
	}

	@Override
	public WorkerPaylevelSalary findWorkerPaySalByPayLevel(Integer payLevel) {
		return IWorkerSalaryDao.findWorkerPaySalByPayLevel(payLevel);
	}
}
