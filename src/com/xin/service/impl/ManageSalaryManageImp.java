package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.IManageSalaryDao;
import com.xin.bean.ManagePaylevelSalary;
import com.xin.bean.ManagePositionSalary;
import com.xin.bean.ManageSalaryChange;
import com.xin.service.IManageSalaryManage;
/**
 * 
    * @ClassName: ManageSalaryManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class ManageSalaryManageImp implements IManageSalaryManage{
	private ManagePositionSalary managePositionSalary;
	private ManagePaylevelSalary managePaylevelSalary;
	private ManageSalaryChange manageSalaryChange;
	
	@Resource
	private IManageSalaryDao ImanageSalaryDao;
	
	public ManagePositionSalary getManagePositionSalary() {
		return managePositionSalary;
	}

	public void setManagePositionSalary(ManagePositionSalary managePositionSalary) {
		this.managePositionSalary = managePositionSalary;
	}

	public ManageSalaryChange getManageSalaryChange() {
		return manageSalaryChange;
	}

	public void setManageSalaryChange(ManageSalaryChange manageSalaryChange) {
		this.manageSalaryChange = manageSalaryChange;
	}

	public ManagePaylevelSalary getManagePaylevelSalary() {
		return managePaylevelSalary;
	}

	public void setManagePaylevelSalary(ManagePaylevelSalary managePaylevelSalary) {
		this.managePaylevelSalary = managePaylevelSalary;
	}

	public IManageSalaryDao getManageSalaryDao() {
		return ImanageSalaryDao;
	}

	public void setManageSalaryDao(IManageSalaryDao manageSalaryDao) {
		this.ImanageSalaryDao = manageSalaryDao;
	}
	
	@Override
	public void addManPaySal(ManagePaylevelSalary manPaylevelSalary) {
		ImanageSalaryDao.addManPaySal(manPaylevelSalary);
	}
	
	@Override
	public void modifyManPaySal(ManagePaylevelSalary manPaylevelSalary) {
		findManPaySalByPayLevel(manPaylevelSalary.getPayLevel());
		getManagePaylevelSalary().setSalaryStandard(manPaylevelSalary.getSalaryStandard());
		ImanageSalaryDao.modifyManPaySal(getManagePaylevelSalary());
	}

	@Override
	public void deleteManPaySal() {
		// TODO Auto-generated method stub
		ImanageSalaryDao.deleteManPaySal(getManagePaylevelSalary());
	}

	@Override
	public ManagePaylevelSalary findManPaySalByPayLevel(Integer payLevel) {
		this.managePaylevelSalary=ImanageSalaryDao.findManPaySalByPayLevel(payLevel);
		
		return this.managePaylevelSalary;
	}

	@Override
	public void addManPosSal(ManagePositionSalary managePositionSalary) {
		ImanageSalaryDao.addManPosSal(managePositionSalary);
	}

	@Override
	public void modifyManPosSal(ManagePositionSalary managePositionSalary) {
		ImanageSalaryDao.modifyManPosSal(managePositionSalary);
	}

	@Override
	public void deleteManPosSal() {
		ImanageSalaryDao.deleteManPosSal(getManagePositionSalary());
	}

	@Override
	public ManagePositionSalary findManPosSalByLevel(Integer level) {
		// TODO Auto-generated method stub
		this.managePositionSalary=ImanageSalaryDao.findManPosSalByLevel(level);
		return this.managePositionSalary;
	}

	@Override
	public void addManSalCha(ManageSalaryChange manageSalaryChange) {
		// TODO Auto-generated method stub
		ImanageSalaryDao.addManSalCha(manageSalaryChange);
	}

	@Override
	public void modifyManSalCha(ManageSalaryChange manageSalaryChange) {
		// TODO Auto-generated method stub
		findManSalChaByLevel(manageSalaryChange.getPositionLevel(), manageSalaryChange.getUpperBoundOfChangeYear(), manageSalaryChange.getUpperBoundOfChangeYear());
		getManageSalaryChange().setPayLevel(manageSalaryChange.getPayLevel());
		ImanageSalaryDao.modifyManSalCha(manageSalaryChange);
	}

	@Override
	public void deleteManSalCha() {
		// TODO Auto-generated method stub
		ImanageSalaryDao.deleteManSalCha(manageSalaryChange);
	}

	@Override
	public ManageSalaryChange findManSalChaByLevel(Integer level,Integer off,Integer cha) {
		// TODO Auto-generated method stub
		this.manageSalaryChange=ImanageSalaryDao.findManSalChaByLevel(level,off,cha);
		return this.manageSalaryChange;
	}

	@Override
	public Integer getSalary() {
		// TODO Auto-generated method stub
		return managePaylevelSalary.getSalaryStandard()+managePositionSalary.getSalaryStandard();
	}

	@Override
	public void setAllManage(Integer level,Integer off,Integer cha) {
		//System.out.println(level);
		// TODO Auto-generated method stub
		Integer payLevel;
		findManPosSalByLevel(level);
		findManSalChaByLevel(level,off,cha);
		if(getManageSalaryChange()==null){
			payLevel=managePositionSalary.getStartPayLevel();
		}
		else {
			payLevel=manageSalaryChange.getPayLevel();
		}
		//System.out.println(.getPayLevel());
		findManPaySalByPayLevel(payLevel);
		
	}

	@Override
	public List<ManagePaylevelSalary> findAllPayLevelSalary() {
		// TODO Auto-generated method stub
		return ImanageSalaryDao.findAllPayLevelSalary();
	}

	@Override
	public List<ManagePositionSalary> findAllPositionSalary() {
		// TODO Auto-generated method stub
		return ImanageSalaryDao.findAllPositionSalary();
	}

	@Override
	public Integer getPayLevel(Integer level, Integer off, Integer cha) {
		// TODO Auto-generated method stub
		setAllManage(level, off, cha);
		
		return managePaylevelSalary.getPayLevel();
	}
}
