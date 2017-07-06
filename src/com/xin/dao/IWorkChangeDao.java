package com.xin.dao;

import java.util.List;

import com.xin.bean.WorkChange;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IWorkChangeDao {
	public void addWorkChange(WorkChange workChange);
	public void deleteWorkChange(WorkChange workChange);
	public void modifyWorkChange(WorkChange workChange);
	public List<WorkChange> findWorkChangeByEId(Integer eId);
}
