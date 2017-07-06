package com.xin.dao;

import java.util.List;

import com.xin.bean.ManagePaylevelSalary;
import com.xin.bean.ManagePositionSalary;
import com.xin.bean.ManageSalaryChange;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(管理人员薪级工资接口)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IManageSalaryDao {
	public void addManPaySal(ManagePaylevelSalary manPaylevelSalary);//增加管理人员薪级工资映射
	public void modifyManPaySal(ManagePaylevelSalary manPaylevelSalary);//根据薪级修改管理人员薪级工资映射
	public void deleteManPaySal(ManagePaylevelSalary manPaylevelSalary);//删除管理人员薪级工资映射
	public ManagePaylevelSalary findManPaySalByPayLevel(Integer payLevel);//根据薪级获得管理人员薪级工资映射记录
	public List<ManagePaylevelSalary> findAllPayLevelSalary();//获得所有管理人员薪级工资映射
	
	public void addManPosSal(ManagePositionSalary managePositionSalary);//增加管理人员职务映射
	public void modifyManPosSal(ManagePositionSalary managePositionSalary);//根据级别修改管理人员职务映射
	public void deleteManPosSal(ManagePositionSalary managePositionSalary);//删除管理人员职务映射
	public ManagePositionSalary findManPosSalByLevel(Integer level);//根据级别获得管理人员职务工资映射记录
	public List<ManagePositionSalary> findAllPositionSalary();//获得所有管理人员职务工资映射
	
	public void addManSalCha(ManageSalaryChange manageSalaryChange);//增加管理人员套改工资映射
	public void modifyManSalCha(ManageSalaryChange manageSalaryChange);//根据级别和相应工作年限修改管理人员套改工资映射
	public void deleteManSalCha(ManageSalaryChange manageSalaryChange);//删除管理人员套改工资映射
	public ManageSalaryChange findManSalChaByLevel(Integer level,Integer off,Integer cha);//根据级别和相应工作年限获得套改工资映射记录
}
