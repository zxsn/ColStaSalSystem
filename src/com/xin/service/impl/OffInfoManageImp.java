package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;


import com.xin.dao.IOffInfoDao;
import com.xin.bean.OffInfo;
import com.xin.service.IOffInfoManage;
/**
 * 
    * @ClassName: OffInfoManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class OffInfoManageImp implements IOffInfoManage {

	@Resource
	private IOffInfoDao offInfoDao;

	@Override
	public void addOffInfo(OffInfo offInfo) {
		offInfoDao.addOffInfo(offInfo);
		
	}

	@Override
	public void deleteOffInfo(OffInfo offInfo) {
		offInfoDao.deleteOffInfo(offInfo);
		
	}

	@Override
	public void modifyOffInfo(OffInfo offInfo) {
		offInfoDao.modifyOffInfo(offInfo);
		
	}

	@Override
	public List<OffInfo> findOffInfoByEId(Integer eId) {
		return offInfoDao.findOffInfoByEId(eId);
	}

	@Override
	public List<OffInfo> findOffInfoThisYear() {
		
		return offInfoDao.findOffInfoThisYear();
	}

	@Override
	public List<OffInfo> findOffInfoThisYearByEId(Integer eId) {
		return offInfoDao.findOffInfoThisYearByEId(eId);
	}

}
