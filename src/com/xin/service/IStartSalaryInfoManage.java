package com.xin.service;

import java.util.List;

import com.xin.bean.StartSalaryInfo;
/**
 * 
    * @ClassName: IStartSalaryInfoManage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IStartSalaryInfoManage {
	public void addStartSalaryInfo(StartSalaryInfo startSalaryInfo);
	public void modifyStartSalaryInfo(StartSalaryInfo startSalaryInfo);
	public void deleteStartSalaryInfo(StartSalaryInfo startSalaryInfo);
	public StartSalaryInfo findStartSalaryInfoByEId(Integer eid);
	public List<StartSalaryInfo> getAllStartSalaryInfo();
}
