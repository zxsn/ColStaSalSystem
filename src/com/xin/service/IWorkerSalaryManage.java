package com.xin.service;

import java.util.List;

import com.xin.bean.WorkerPaylevelSalary;
import com.xin.bean.WorkerPositionSalary;
import com.xin.bean.WorkerSalaryChange;
/**
 * 
    * @ClassName: IWorkerSalaryManage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IWorkerSalaryManage {
	public void addWorkerPaySal(WorkerPaylevelSalary workerPaylevelSalary);//增加工人薪级工资映射
	public void modifyWorkerPaySal(WorkerPaylevelSalary workerPaylevelSalary);//修改工人薪级工资映射
	public void deleteWorkerPaySal();//删除工人薪级工资映射
	public void setWorkerPaySalByPayLevel(Integer payLevel);//根据薪级设置工人薪级工资映射记录
	public List<WorkerPaylevelSalary> findAllPayLevelSalary();//获得所有工人薪级工资映射
	
	public WorkerPositionSalary findWorkerPosSalByLevel(Integer level);
	public void addWorkerPosSal(WorkerPositionSalary workerPositionSalary);//增加工人职务映射
	public void modifyWorkerPosSal(WorkerPositionSalary workerPositionSalary);//修改工人职务映射
	public void deleteWorkerPosSal();//删除工人职务映射
	public void setWorkerPosSalByLevel(Integer level);//根据级别设置工人职务工资映射记录
	public List<WorkerPositionSalary> findAllPositionSalary();//获得所有工人薪级工资映射
	public WorkerPositionSalary findWorPosSalByLevel(Integer level);
	
	public void addWorkerSalCha(WorkerSalaryChange workerSalaryChange);//增加工人套改工资映射
	public void modifyWorkerSalCha(WorkerSalaryChange workerSalaryChange);//修改工人套改工资映射
	public void deleteWorkerSalCha();//删除工人套改工资映射
	public void setWorkerSalChaByLevel(Integer level,Integer off,Integer cha);//根据级别和相应工作年限设置套改工资映射记录
	
	public void setAllManage(Integer level,Integer off,Integer cha);//设置所有私有成员
	public Integer getPayLevel(Integer level,Integer off,Integer cha);//根据相应信息获得薪级
	public WorkerPaylevelSalary findWorkerPaySalByPayLevel(Integer payLevel);
	
	public Integer getSalary();//获得工人工资
}
