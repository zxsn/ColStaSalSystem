
    /**  
    * @Title: IEmployeeManage.java
    * @Package com.xin.service
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.service;

import java.util.List;

import com.xin.bean.Employee;

/**
    * @ClassName: IEmployeeManage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */

public interface IEmployeeManage {
    public void addEmployee(Employee employee);
    public void modifyEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public Employee findEmployeeById(Integer id);
    public List<Employee> findEmployeesByName(String name);
    public List<Employee> findEmployeesByDepartment(String department);
}
