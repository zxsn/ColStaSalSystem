package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.ISpecialSalaryChangeDao;
import com.xin.bean.SpecialSalaryChange;
import com.xin.service.ISpecialSalaryChangeManage;
/**
 * 
    * @ClassName: SpecialSalaryChangeManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class SpecialSalaryChangeManageImp implements ISpecialSalaryChangeManage{
	@Resource
	private ISpecialSalaryChangeDao iSpecialSalaryChangeDao;

	@Override
	public void addSpecialSalaryChange(SpecialSalaryChange SpecialSalaryChange) {
		// TODO Auto-generated method stub
		iSpecialSalaryChangeDao.addSpecialSalaryChange(SpecialSalaryChange);
	}

	@Override
	public void deleteSpecialSalaryChange(SpecialSalaryChange SpecialSalaryChange) {
		// TODO Auto-generated method stub
		iSpecialSalaryChangeDao.deleteSpecialSalaryChange(SpecialSalaryChange);
	}

	@Override
	public void modifySpecialSalaryChange(SpecialSalaryChange SpecialSalaryChange) {
		// TODO Auto-generated method stub
		iSpecialSalaryChangeDao.modifySpecialSalaryChange(SpecialSalaryChange);
	}

	@Override
	public List<SpecialSalaryChange>  findSpecialSalaryChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iSpecialSalaryChangeDao.findSpecialSalaryChangeByEId(eId);
	}

	@Override
	public List<SpecialSalaryChange> findAllSpecialSalaryChange() {
		// TODO Auto-generated method stub
		return iSpecialSalaryChangeDao.findAllSpecialSalaryChange();
	}

}
