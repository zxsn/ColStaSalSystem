package com.xin.dao;

import java.util.List;

import com.xin.bean.AddOrCut;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IAddOrCutDao {
	public void addAddOrCut(AddOrCut addOrCut);
	public void deleteAddOrCut(AddOrCut addOrCut);
	public void modifyAddOrCut(AddOrCut addOrCut);
	public List<AddOrCut> findAddOrCutByEId(Integer eId);
}
