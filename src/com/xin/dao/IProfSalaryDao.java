package com.xin.dao;

import java.util.List;

import com.xin.bean.ProfessionalPaylevelSalary;
import com.xin.bean.ProfessionalPositionSalary;
import com.xin.bean.ProfessionalSalaryChange;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(专业人员薪级工资接口)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IProfSalaryDao {
	public void addProfPaySal(ProfessionalPaylevelSalary profPaylevelSalary);//增加专业人员薪级工资映射
	public void modifyProfPaySal(ProfessionalPaylevelSalary profPaylevelSalary);//根据薪级修改专业人员薪级工资映射
	public void deleteProfPaySal(ProfessionalPaylevelSalary profPaylevelSalary);//删除专业人员薪级工资映射
	public ProfessionalPaylevelSalary findProfPaySalByPayLevel(Integer payLevel);//根据薪级获得专业人员薪级工资映射记录
	public List<ProfessionalPaylevelSalary> findAllPayLevelSalary();//获得所有专业人员薪级工资映射
	
	public void addProfPosSal(ProfessionalPositionSalary profPositionSalary);//增加专业人员职务映射
	public void modifyProfPosSal(ProfessionalPositionSalary profPositionSalary);//根据级别修改专业人员职务映射
	public void deleteProfPosSal(ProfessionalPositionSalary profPositionSalary);//删除专业人员职务映射
	public ProfessionalPositionSalary findProfPosSalByLevel(Integer level);//根据级别获得专业人员职务工资映射记录
	public List<ProfessionalPositionSalary> findAllPositionSalary();//获得所有专业人员职务工资映射
	
	public void addProfSalCha(ProfessionalSalaryChange profSalaryChange);//增加专业人员套改工资映射
	public void modifyProfSalCha(ProfessionalSalaryChange profSalaryChange);//根据级别和相应工作年限修改专业人员套改工资映射
	public void deleteProfSalCha(ProfessionalSalaryChange profSalaryChange);//删除专业人员套改工资映射
	public ProfessionalSalaryChange findProfSalChaByLevel(Integer level,Integer off,Integer cha);//根据级别和相应工作年限获得套改工资映射记录
}
