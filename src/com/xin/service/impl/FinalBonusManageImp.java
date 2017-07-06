package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.IFinalBonusDao;
import com.xin.bean.FinalBonus;
import com.xin.service.IFinalBonusManage;
/**
 * 
    * @ClassName: FinalBonusManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class FinalBonusManageImp implements IFinalBonusManage{
	@Resource
	private IFinalBonusDao iFinalBonusDao;

	@Override
	public void addFinalBonus(FinalBonus finalBonus) {
		
		iFinalBonusDao.addFinalBonus(finalBonus);
	}

	@Override
	public void deleteFinalBonus(FinalBonus finalBonus) {
		
		iFinalBonusDao.deleteFinalBonus(finalBonus);
	}

	@Override
	public void modifyFinalBonus(FinalBonus finalBonus) {
		
		iFinalBonusDao.modifyFinalBonus(finalBonus);
	}

	@Override
	public List<FinalBonus> findFinalBonusByEId(Integer eId) {
		
		return iFinalBonusDao.findFinalBonusByEId(eId);
	}

	@Override
	public List<FinalBonus> findFinalBonusByDoubleBonusType(
			String doubleBonusType) {
		
		return iFinalBonusDao.findFinalBonusByDoubleBonusType(doubleBonusType);
	}

}
