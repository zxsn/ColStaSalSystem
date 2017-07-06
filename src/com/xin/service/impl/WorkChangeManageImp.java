package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.IWorkChangeDao;
import com.xin.bean.WorkChange;
import com.xin.service.IWorkChangeManage;
/**
 * 
    * @ClassName: WorkChangeManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class WorkChangeManageImp implements IWorkChangeManage{
	@Resource
	private IWorkChangeDao iWorkChangeDao;

	@Override
	public void addWorkChange(WorkChange workChange) {
		// TODO Auto-generated method stub
		iWorkChangeDao.addWorkChange(workChange);
	}

	@Override
	public void deleteWorkChange(WorkChange workChange) {
		// TODO Auto-generated method stub
		iWorkChangeDao.deleteWorkChange(workChange);
	}

	@Override
	public void modifyWorkChange(WorkChange workChange) {
		// TODO Auto-generated method stub
		iWorkChangeDao.modifyWorkChange(workChange);
	}

	@Override
	public List<WorkChange> findWorkChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iWorkChangeDao.findWorkChangeByEId(eId);
	}

}
