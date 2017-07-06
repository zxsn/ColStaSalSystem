package com.xin.service;

import java.util.List;

import com.xin.bean.ManagePaylevelSalary;
import com.xin.bean.ManagePositionSalary;
import com.xin.bean.ManageSalaryChange;
/**
 * 
    * @ClassName: IManageSalaryManage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IManageSalaryManage {
	public void addManPaySal(ManagePaylevelSalary manPaylevelSalary);//增加管理人员薪级工资映射
	public void modifyManPaySal(ManagePaylevelSalary manPaylevelSalary);//修改管理人员薪级工资映射
	public void deleteManPaySal();//删除管理人员薪级工资映射
	public ManagePaylevelSalary findManPaySalByPayLevel(Integer payLevel);//根据薪级设置管理人员薪级工资映射记录
	public List<ManagePaylevelSalary> findAllPayLevelSalary();//获得所有管理人员薪级工资映射
	
	public void addManPosSal(ManagePositionSalary managePositionSalary);//增加管理人员职务映射
	public void modifyManPosSal(ManagePositionSalary managePositionSalary);//修改管理人员职务映射
	public void deleteManPosSal();//删除管理人员职务映射
	public ManagePositionSalary findManPosSalByLevel(Integer level);//根据级别设置管理人员职务工资映射记录
	public List<ManagePositionSalary> findAllPositionSalary();//获得所有管理人员职务工资映射
	
	public void addManSalCha(ManageSalaryChange manageSalaryChange);//增加管理人员套改工资映射
	public void modifyManSalCha(ManageSalaryChange manageSalaryChange);//修改管理人员套改工资映射
	public void deleteManSalCha();//删除管理人员套改工资映射
	public ManageSalaryChange findManSalChaByLevel(Integer level,Integer off,Integer cha);//根据级别和相应工作年限设置套改工资映射记录
	
	public void setAllManage(Integer level,Integer off,Integer cha);//设置所有私有成员
	public Integer getPayLevel(Integer level,Integer off,Integer cha);//根据相应信息获得薪级
	
	public Integer getSalary();//获得管理人员工资
}
