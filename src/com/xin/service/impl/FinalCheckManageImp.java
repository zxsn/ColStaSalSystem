package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.IFinalCheckDao;
import com.xin.bean.FinalCheck;
import com.xin.service.IFinalCheckManage;
/**
 * 
    * @ClassName: FinalCheckManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class FinalCheckManageImp implements IFinalCheckManage{
	@Resource
	private IFinalCheckDao iFinalCheckDao;

	@Override
	public void addFinalCheck(FinalCheck finalCheck) {
		List<FinalCheck> checks = iFinalCheckDao.findFinalCheckByEId(finalCheck.geteId());
		for (FinalCheck f:checks) {
			if(f.getYear() == finalCheck.getYear()) {
				f.setCheckResult(finalCheck.getCheckResult());
				iFinalCheckDao.modifyFinalCheck(f);
				return;
			}
		}
			
		iFinalCheckDao.addFinalCheck(finalCheck);
	}

	@Override
	public void deleteFinalCheck(FinalCheck finalCheck) {
		iFinalCheckDao.deleteFinalCheck(finalCheck);
	}

	@Override
	public void modifyFinalCheck(FinalCheck finalCheck) {
		iFinalCheckDao.modifyFinalCheck(finalCheck);
	}

	@Override
	public List<FinalCheck> findFinalCheckByEId(Integer eId) {
		return iFinalCheckDao.findFinalCheckByEId(eId);
	}

	@Override
	public List<FinalCheck> findFinalChecksByResult(String result) {
		return iFinalCheckDao.findFinalChecksByResult(result);
	}

}
