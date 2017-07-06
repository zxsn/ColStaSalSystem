package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.IExperiencesDao;
import com.xin.bean.Experiences;
import com.xin.service.IExperiencesManage;
/**
 * 
    * @ClassName: ExperiencesManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class ExperiencesManageImp implements IExperiencesManage {
	@Resource
	IExperiencesDao experiencesDao;
	
	@Override
	public void addExperiences(Experiences experiences) {
		experiencesDao.addExperiences(experiences);
	}
	
	@Override
	public void modifyExperiences(Experiences experiences) {
		experiencesDao.modifyExperiences(experiences);
	}
	
	@Override
	public void deleteExperiences(Experiences experiences) {
		experiencesDao.deleteExperiences(experiences);
	}
	
	@Override
	public List<Experiences> findManageExperiencesListByEid(Integer eid) {
		return experiencesDao.findManageExperiencesListByEid(eid);
	}
	
	@Override
	public List<Experiences> findProfExperiencesListByEid(Integer eid) {
		return experiencesDao.findProfExperiencesListByEid(eid);
	}
	
	@Override
	public List<Experiences> findWorkerExperiencesListByEid(Integer eid) {
		return experiencesDao.findWorkerExperiencesListByEid(eid);
	}
	
	@Override
	public List<Experiences> findEduExperiencesListByEid(Integer eid) {
		return experiencesDao.findEduExperiencesListByEid(eid);
	}
}
