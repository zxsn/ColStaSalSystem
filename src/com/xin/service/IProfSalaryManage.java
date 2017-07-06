package com.xin.service;

import java.util.List;

import com.xin.bean.ProfessionalPaylevelSalary;
import com.xin.bean.ProfessionalPositionSalary;
import com.xin.bean.ProfessionalSalaryChange;
/**
 * 
    * @ClassName: IProfSalaryManage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IProfSalaryManage {
	public void addProfPaySal(ProfessionalPaylevelSalary profPaylevelSalary);//增加专业人员薪级工资映射
	public void modifyProfPaySal(ProfessionalPaylevelSalary profPaylevelSalary);//修改专业人员薪级工资映射
	public void deleteProfPaySal();//删除专业人员薪级工资映射
	public void setProfPaySalByPayLevel(Integer payLevel);//根据薪级设置专业人员薪级工资映射记录
	public List<ProfessionalPaylevelSalary> findAllPayLevelSalary();//获得所有专业人员薪级工资映射
	
	public void addProfPosSal(ProfessionalPositionSalary profPositionSalary);//增加专业人员职务映射
	public void modifyProfPosSal(ProfessionalPositionSalary profPositionSalary);//修改专业人员职务映射
	public void deleteProfPosSal();//删除专业人员职务映射
	public void setProfPosSalByLevel(Integer level);//根据级别设置专业人员职务工资映射记录
	public ProfessionalPositionSalary findProfPosSalByLevel(Integer level);//根据级别返回专业人员职务工资映射记录
	public List<ProfessionalPositionSalary> findAllPositionSalary();//获得所有专业人员薪级工资映射
	
	public void addProfSalCha(ProfessionalSalaryChange profSalaryChange);//增加专业人员套改工资映射
	public void modifyProfSalCha(ProfessionalSalaryChange profSalaryChange);//修改专业人员套改工资映射
	public void deleteProfSalCha();//删除专业人员套改工资映射
	public ProfessionalSalaryChange findProfSalChaByLevel(Integer level,Integer off,Integer cha);//根据级别和相应工作年限设置套改工资映射记录
	
	public ProfessionalPaylevelSalary findProfPaySalByPayLevel(Integer level);
	public void setAllManage(Integer level,Integer off,Integer cha);//设置所有私有成员
	public Integer getPayLevel(Integer level,Integer off,Integer cha);//根据相应信息获得薪级
	
	public Integer getSalary();//获得专业人员工资
}
