package com.xin.dao;

import java.util.List;

import com.xin.bean.TitleChange;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface ITitleChangeDao {
	public void addTitleChange(TitleChange titleChange);
	public void deleteTitleChange(TitleChange titleChange);
	public void modifyTitleChange(TitleChange titleChange);
	public List<TitleChange> findTitleChangeByEId(Integer eId);
}
