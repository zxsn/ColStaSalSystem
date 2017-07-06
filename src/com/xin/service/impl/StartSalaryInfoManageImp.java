package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.IStartSalaryInfoDao;
import com.xin.bean.StartSalaryInfo;
import com.xin.service.IStartSalaryInfoManage;
/**
 * 
    * @ClassName: StartSalaryInfoManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class StartSalaryInfoManageImp implements IStartSalaryInfoManage {
	
	@Resource
	private IStartSalaryInfoDao startSalaryInfoDao;

	public IStartSalaryInfoDao getStartSalaryInfoDao() {
		return startSalaryInfoDao;
	}

	public void setStartSalaryInfoDao(IStartSalaryInfoDao startSalaryInfoDao) {
		this.startSalaryInfoDao = startSalaryInfoDao;
	}
	
	@Override
	public void addStartSalaryInfo(StartSalaryInfo startSalaryInfo)
	{
		startSalaryInfoDao.addStartSalaryInfo(startSalaryInfo);
	}
	
	@Override
	public void modifyStartSalaryInfo(StartSalaryInfo startSalaryInfo)
	{
		startSalaryInfoDao.modifyStartSalaryInfo(startSalaryInfo);
	}
	
	@Override
	public void deleteStartSalaryInfo(StartSalaryInfo startSalaryInfo)
	{
		startSalaryInfoDao.deleteStartSalaryInfo(startSalaryInfo);
	}
	
	@Override
	public StartSalaryInfo findStartSalaryInfoByEId(Integer eid)
	{
		return startSalaryInfoDao.findStartSalaryInfoByEId(eid);
	}

	@Override
	public List<StartSalaryInfo> getAllStartSalaryInfo() {
		// TODO Auto-generated method stub
		return  startSalaryInfoDao.getAllStartSalaryInfo();
	}
}
