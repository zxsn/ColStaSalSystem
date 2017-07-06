package com.xin.dao;

import java.util.List;

import com.xin.bean.FinalCheck;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IFinalCheckDao {
	public void addFinalCheck(FinalCheck finalCheck);
	public void deleteFinalCheck(FinalCheck finalCheck);
	public void modifyFinalCheck(FinalCheck finalCheck);
	public List<FinalCheck> findFinalCheckByEId(Integer eId);
	public List<FinalCheck> findFinalChecksByResult(String result);
}
