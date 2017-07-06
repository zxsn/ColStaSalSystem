package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.IProfSalaryDao;
import com.xin.bean.ProfessionalPaylevelSalary;
import com.xin.bean.ProfessionalPositionSalary;
import com.xin.bean.ProfessionalSalaryChange;
import com.xin.service.IProfSalaryManage;
/**
 * 
    * @ClassName: ProfSalaryManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class ProfSalaryManageImp implements IProfSalaryManage{
	private ProfessionalPositionSalary profPositionSalary;
	private ProfessionalPaylevelSalary profPaylevelSalary;
	private ProfessionalSalaryChange profSalaryChange;
	
	@Resource
	private IProfSalaryDao IProfSalaryDao;
	
	public ProfessionalPositionSalary getProfessionalPositionSalary() {
		return profPositionSalary;
	}

	public void setProfessionalPositionSalary(ProfessionalPositionSalary ProfessionalPositionSalary) {
		this.profPositionSalary = ProfessionalPositionSalary;
	}

	public ProfessionalSalaryChange getProfessionalSalaryChange() {
		return profSalaryChange;
	}

	public void setProfessionalSalaryChange(ProfessionalSalaryChange ProfessionalSalaryChange) {
		this.profSalaryChange = ProfessionalSalaryChange;
	}

	public ProfessionalPaylevelSalary getProfessionalPaylevelSalary() {
		return profPaylevelSalary;
	}

	public void setProfessionalPaylevelSalary(ProfessionalPaylevelSalary ProfessionalPaylevelSalary) {
		this.profPaylevelSalary = ProfessionalPaylevelSalary;
	}

	public IProfSalaryDao getProfessionalSalaryDao() {
		return IProfSalaryDao;
	}

	public void setProfessionalSalaryDao(IProfSalaryDao ProfSalaryDao) {
		this.IProfSalaryDao = ProfSalaryDao;
	}
	
	@Override
	public void addProfPaySal(ProfessionalPaylevelSalary ProfPaylevelSalary) {
		// TODO Auto-generated method stub
		IProfSalaryDao.addProfPaySal(ProfPaylevelSalary);
	}
	
	@Override
	public void modifyProfPaySal(ProfessionalPaylevelSalary ProfPaylevelSalary) {
		// TODO Auto-generated method stub
		setProfPaySalByPayLevel(ProfPaylevelSalary.getPayLevel());
		getProfessionalPaylevelSalary().setSalaryStandard(ProfPaylevelSalary.getSalaryStandard());
		IProfSalaryDao.modifyProfPaySal(getProfessionalPaylevelSalary());
	}

	@Override
	public void deleteProfPaySal() {
		// TODO Auto-generated method stub
		IProfSalaryDao.deleteProfPaySal(getProfessionalPaylevelSalary());
	}

	@Override
	public void setProfPaySalByPayLevel(Integer payLevel) {
		// TODO Auto-generated method stub
		this.profPaylevelSalary=IProfSalaryDao.findProfPaySalByPayLevel(payLevel);
	}

	@Override
	public ProfessionalPositionSalary findProfPosSalByLevel(Integer level) {
		this.profPositionSalary = IProfSalaryDao.findProfPosSalByLevel(level);
		return this.profPositionSalary;
	}
	
	@Override
	public void addProfPosSal(ProfessionalPositionSalary ProfPositionSalary) {
		// TODO Auto-generated method stub
		IProfSalaryDao.addProfPosSal(ProfPositionSalary);
	}

	@Override
	public void modifyProfPosSal(ProfessionalPositionSalary ProfPositionSalary) {
		// TODO Auto-generated method stub
		setProfPosSalByLevel(ProfPositionSalary.getLevel());
		getProfessionalPositionSalary().setSalaryStandard(ProfPositionSalary.getSalaryStandard());
		getProfessionalPositionSalary().setPosition(ProfPositionSalary.getPosition());
		IProfSalaryDao.modifyProfPosSal(getProfessionalPositionSalary());
	}

	@Override
	public void deleteProfPosSal() {
		// TODO Auto-generated method stub
		IProfSalaryDao.deleteProfPosSal(getProfessionalPositionSalary());
	}

	@Override
	public void setProfPosSalByLevel(Integer level) {
		// TODO Auto-generated method stub
		this.profPositionSalary=IProfSalaryDao.findProfPosSalByLevel(level);
	}

	@Override
	public void addProfSalCha(ProfessionalSalaryChange ProfSalaryChange) {
		// TODO Auto-generated method stub
		IProfSalaryDao.addProfSalCha(ProfSalaryChange);
	}

	@Override
	public void modifyProfSalCha(ProfessionalSalaryChange ProfSalaryChange) {
		// TODO Auto-generated method stub
		findProfSalChaByLevel(ProfSalaryChange.getPositionLevel(), ProfSalaryChange.getUpperBoundOfChangeYear(), ProfSalaryChange.getUpperBoundOfChangeYear());
		getProfessionalSalaryChange().setPayLevel(ProfSalaryChange.getPayLevel());
		IProfSalaryDao.modifyProfSalCha(ProfSalaryChange);
	}

	@Override
	public void deleteProfSalCha() {
		// TODO Auto-generated method stub
		IProfSalaryDao.deleteProfSalCha(profSalaryChange);
	}

	@Override
	public ProfessionalSalaryChange findProfSalChaByLevel(Integer level,Integer off,Integer cha) {
		// TODO Auto-generated method stub
		this.profSalaryChange=IProfSalaryDao.findProfSalChaByLevel(level,off,cha);
		return this.profSalaryChange;
	}

	@Override
	public Integer getSalary() {
		// TODO Auto-generated method stub
		return profPaylevelSalary.getSalaryStandard()+profPositionSalary.getSalaryStandard();
	}

	@Override
	public void setAllManage(Integer level,Integer off,Integer cha) {
		//System.out.println(level);
		// TODO Auto-generated method stub				
		Integer payLevel;
		findProfPosSalByLevel(level);
		findProfSalChaByLevel(level,off,cha);
		if(getProfessionalSalaryChange()==null){
			payLevel=profPositionSalary.getStartPayLevel();
		}
		else {
			payLevel=profSalaryChange.getPayLevel();
		}
		//System.out.println(.getPayLevel());
		findProfPaySalByPayLevel(payLevel);
	}

	@Override
	public List<ProfessionalPaylevelSalary> findAllPayLevelSalary() {
		// TODO Auto-generated method stub
		return IProfSalaryDao.findAllPayLevelSalary();
	}

	@Override
	public List<ProfessionalPositionSalary> findAllPositionSalary() {
		// TODO Auto-generated method stub
		return IProfSalaryDao.findAllPositionSalary();
	}

	@Override
	public Integer getPayLevel(Integer level, Integer off, Integer cha) {
		// TODO Auto-generated method stub
		setAllManage(level, off, cha);
		
		return profPaylevelSalary.getPayLevel();
	}

	@Override
	public ProfessionalPaylevelSalary findProfPaySalByPayLevel(Integer payLevel) {
		// TODO Auto-generated method stub
		this.profPaylevelSalary=IProfSalaryDao.findProfPaySalByPayLevel(payLevel);
		
		return this.profPaylevelSalary;
	}
	
	
}
