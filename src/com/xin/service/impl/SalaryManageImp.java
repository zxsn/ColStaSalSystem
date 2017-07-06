package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.ISalaryDao;
import com.xin.bean.Salary;
import com.xin.service.ISalaryManage;
/**
 * 
    * @ClassName: SalaryManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class SalaryManageImp implements ISalaryManage{
	
	@Resource
	private ISalaryDao salaryDao;

	public ISalaryDao getSalaryDao() {
		return salaryDao;
	}

	public void setSalaryDao(ISalaryDao salaryDao) {
		this.salaryDao = salaryDao;
	}
	
	@Override
	public void addSalary(Salary salary)
	{
		salaryDao.addSalary(salary);
	}
	
	@Override
	public void modifySalary(Salary salary)
	{
		salaryDao.modifySalary(salary);
	}
	
	@Override
	public void deleteSalary(Salary salary)
	{
		salaryDao.deleteSalary(salary);
	}
	
	@Override
	public Salary findSalaryById(Integer id)
	{
		return salaryDao.findSalaryById(id);
	}

	@Override
	public List<Salary> findSalaryByEId(Integer eid) {
		return salaryDao.findSalaryByEId(eid);
	}

	@Override
	public Salary findLastSalaryByEId(Integer eid) {
		return salaryDao.findLastSalaryById(eid);
	}
}
