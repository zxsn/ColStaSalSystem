package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.IDepartmentChangeDao;
import com.xin.bean.DepartmentChange;
import com.xin.service.IDepartmentChangeManage;
/**
 * 
    * @ClassName: DepartmentChangeManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class DepartmentChangeManageImp implements IDepartmentChangeManage{
	@Resource
	private IDepartmentChangeDao iDepartmentChangeDao;

	@Override
	public void addDepartmentChange(DepartmentChange departmentChange) {
		// TODO Auto-generated method stub
		iDepartmentChangeDao.addDepartmentChange(departmentChange);
	}

	@Override
	public void deleteDepartmentChange(DepartmentChange departmentChange) {
		// TODO Auto-generated method stub
		iDepartmentChangeDao.deleteDepartmentChange(departmentChange);
	}

	@Override
	public void modifyDepartmentChange(DepartmentChange departmentChange) {
		// TODO Auto-generated method stub
		iDepartmentChangeDao.modifyDepartmentChange(departmentChange);
	}

	@Override
	public List<DepartmentChange> findDepartmentChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iDepartmentChangeDao.findDepartmentChangeByEId(eId);
	}

}
