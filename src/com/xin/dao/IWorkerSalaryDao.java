package com.xin.dao;

import java.util.List;

import com.xin.bean.WorkerPaylevelSalary;
import com.xin.bean.WorkerPositionSalary;
import com.xin.bean.WorkerSalaryChange;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(工人薪级工资接口)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IWorkerSalaryDao {
	public void addWorkerPaySal(WorkerPaylevelSalary workerPaylevelSalary);//增加工人薪级工资映射
	public void modifyWorkerPaySal(WorkerPaylevelSalary workerPaylevelSalary);//根据薪级修改工人薪级工资映射
	public void deleteWorkerPaySal(WorkerPaylevelSalary workerPaylevelSalary);//删除工人薪级工资映射
	public WorkerPaylevelSalary findWorkerPaySalByPayLevel(Integer payLevel);//根据薪级获得工人薪级工资映射记录
	public List<WorkerPaylevelSalary> findAllPayLevelSalary();//获得所有工人薪级工资映射
	
	public void addWorkerPosSal(WorkerPositionSalary workerPositionSalary);//增加工人职务映射
	public void modifyWorkerPosSal(WorkerPositionSalary workerPositionSalary);//根据级别修改工人职务映射
	public void deleteWorkerPosSal(WorkerPositionSalary workerPositionSalary);//删除工人职务映射
	public WorkerPositionSalary findWorkerPosSalByLevel(Integer level);//根据级别获得工人职务工资映射记录
	public List<WorkerPositionSalary> findAllPositionSalary();//获得所有工人职务工资映射
	
	public void addWorkerSalCha(WorkerSalaryChange workerSalaryChange);//增加工人套改工资映射
	public void modifyWorkerSalCha(WorkerSalaryChange workerSalaryChange);//根据级别和相应工作年限修改工人套改工资映射
	public void deleteWorkerSalCha(WorkerSalaryChange workerSalaryChange);//删除工人套改工资映射
	public WorkerSalaryChange findWorkerSalChaByLevel(Integer level,Integer off,Integer cha);//根据级别和相应工作年限获得套改工资映射记录
}
