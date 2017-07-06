
    /**  
    * @Title: IDepartmentChangeManage.java
    * @Package com.xin.service
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.service;

import java.util.List;

import com.xin.bean.DepartmentChange;

/**
    * @ClassName: IDepartmentChangeManage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */

public interface IDepartmentChangeManage {
    public void addDepartmentChange(DepartmentChange departmentChange);
    public void deleteDepartmentChange(DepartmentChange departmentChange);
    public void modifyDepartmentChange(DepartmentChange departmentChange);
    public List<DepartmentChange> findDepartmentChangeByEId(Integer eId);
}
