package com.xin.dao;

import java.util.List;

import com.xin.bean.Experiences;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IExperiencesDao {
	public void addExperiences(Experiences experiences);
	public void modifyExperiences(Experiences experiences);
	public void deleteExperiences(Experiences experiences);
	
	public List<Experiences> findManageExperiencesListByEid(Integer eid);
	public List<Experiences> findProfExperiencesListByEid(Integer eid);
	public List<Experiences> findWorkerExperiencesListByEid(Integer eid);
	public List<Experiences> findEduExperiencesListByEid(Integer eid);
}
