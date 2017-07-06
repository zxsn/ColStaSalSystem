package com.xin.dao;

import java.util.List;

import com.xin.bean.OffInfo;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IOffInfoDao {
	public void addOffInfo(OffInfo offInfo);
	public void deleteOffInfo(OffInfo offInfo);
	public void modifyOffInfo(OffInfo offInfo);
	public List<OffInfo> findOffInfoByEId(Integer eId);
	public List<OffInfo> findOffInfoThisYear();
	public List<OffInfo> findOffInfoThisYearByEId(Integer eId);
}
