package com.xin.dao;

import java.util.List;

import com.xin.bean.SpecialSalaryRecovery;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface ISpecialSalaryRecoveryDao {
	public void addSpecialSalaryRecovery(SpecialSalaryRecovery specialSalaryRecovery);
	public void deleteSpecialSalaryRecovery(SpecialSalaryRecovery specialSalaryRecovery);
	public void modifySpecialSalaryRecovery(SpecialSalaryRecovery specialSalaryRecovery);
	public List<SpecialSalaryRecovery> findSpecialSalaryRecoveryByEId(Integer eId);
	public List<SpecialSalaryRecovery> findAllSpecialSalaryRecovery();
}
