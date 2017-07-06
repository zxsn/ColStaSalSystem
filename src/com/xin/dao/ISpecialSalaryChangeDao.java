package com.xin.dao;

import java.util.List;

import com.xin.bean.SpecialSalaryChange;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface ISpecialSalaryChangeDao {
	public void addSpecialSalaryChange(SpecialSalaryChange specialSalaryChange);
	public void deleteSpecialSalaryChange(SpecialSalaryChange specialSalaryChange);
	public void modifySpecialSalaryChange(SpecialSalaryChange specialSalaryChange);
	public List<SpecialSalaryChange> findSpecialSalaryChangeByEId(Integer eId);
	public List<SpecialSalaryChange> findAllSpecialSalaryChange();
}
