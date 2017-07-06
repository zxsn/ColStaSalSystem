package com.xin.dao;

import java.util.List;

import com.xin.bean.FinalBonus;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IFinalBonusDao {
	public void addFinalBonus(FinalBonus finalBonus);
	public void deleteFinalBonus(FinalBonus finalBonus);
	public void modifyFinalBonus(FinalBonus finalBonus);
	public List<FinalBonus> findFinalBonusByEId(Integer eId);
	public List<FinalBonus> findFinalBonusByDoubleBonusType(
			String doubleBonusType);
}
