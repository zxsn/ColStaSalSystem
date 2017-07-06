package com.xin.dao;

import java.util.List;

import com.xin.bean.Salary;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface ISalaryDao {
	public void addSalary(Salary salary);
	public void modifySalary(Salary salary);
	public void deleteSalary(Salary salary);
	public Salary findSalaryById(Integer id);
	public List<Salary> findSalaryByEId(Integer eid);
	public Salary findLastSalaryById(Integer eid);
}
