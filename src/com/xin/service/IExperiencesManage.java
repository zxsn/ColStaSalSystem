
    /**  
    * @Title: IExperiencesManage.java
    * @Package com.xin.service
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.service;

import java.util.List;

import com.xin.bean.Experiences;

/**
    * @ClassName: IExperiencesManage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */

public interface IExperiencesManage {
    public void addExperiences(Experiences experiences);
    public void modifyExperiences(Experiences experiences);
    public void deleteExperiences(Experiences experiences);
    
    public List<Experiences> findManageExperiencesListByEid(Integer eid);
    public List<Experiences> findProfExperiencesListByEid(Integer eid);
    public List<Experiences> findWorkerExperiencesListByEid(Integer eid);
    public List<Experiences> findEduExperiencesListByEid(Integer eid);
}
