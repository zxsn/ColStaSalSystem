package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.ISpecialSalaryRecoveryDao;
import com.xin.bean.SpecialSalaryRecovery;
import com.xin.service.ISpecialSalaryRecoveryManage;
/**
 * 
    * @ClassName: SpecialSalaryRecoveryManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class SpecialSalaryRecoveryManageImp implements ISpecialSalaryRecoveryManage{
	@Resource
	private ISpecialSalaryRecoveryDao iSpecialSalaryRecoveryDao;

	@Override
	public void addSpecialSalaryRecovery(SpecialSalaryRecovery SpecialSalaryRecovery) {
		// TODO Auto-generated method stub
		iSpecialSalaryRecoveryDao.addSpecialSalaryRecovery(SpecialSalaryRecovery);
	}

	@Override
	public void deleteSpecialSalaryRecovery(SpecialSalaryRecovery SpecialSalaryRecovery) {
		// TODO Auto-generated method stub
		iSpecialSalaryRecoveryDao.deleteSpecialSalaryRecovery(SpecialSalaryRecovery);
	}

	@Override
	public void modifySpecialSalaryRecovery(SpecialSalaryRecovery SpecialSalaryRecovery) {
		// TODO Auto-generated method stub
		iSpecialSalaryRecoveryDao.modifySpecialSalaryRecovery(SpecialSalaryRecovery);
	}

	@Override
	public List<SpecialSalaryRecovery>  findSpecialSalaryRecoveryByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iSpecialSalaryRecoveryDao.findSpecialSalaryRecoveryByEId(eId);
	}

	@Override
	public List<SpecialSalaryRecovery> findAllSpecialSalaryRecovery() {
		// TODO Auto-generated method stub
		return iSpecialSalaryRecoveryDao.findAllSpecialSalaryRecovery();
	}

}
