package com.xin.dao;

import java.util.List;

import com.xin.bean.DepartmentChange;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IDepartmentChangeDao {
	public void addDepartmentChange(DepartmentChange departmentChange);
	public void deleteDepartmentChange(DepartmentChange departmentChange);
	public void modifyDepartmentChange(DepartmentChange departmentChange);
	public List<DepartmentChange> findDepartmentChangeByEId(Integer eId);
}
