package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.IEmployeeDao;
import com.xin.dao.IUserDao;
import com.xin.bean.Employee;
import com.xin.bean.User;
import com.xin.security.Md5;
import com.xin.service.IEmployeeManage;
/**
 * 
    * @ClassName: EmployeeManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class EmployeeManageImp implements IEmployeeManage {
	@Resource
	IEmployeeDao employeeDao;
	@Resource
	IUserDao userDao;

	@Override
	public void addEmployee(Employee employee) {
		if (findEmployeeById(employee.getId()) != null)
			modifyEmployee(employee);
		else {
			employeeDao.addEmployee(employee);

			User user = new User();
			user.setId(employee.getId());
			user.setPassword(Md5.generatePassword(employee.getId().toString()));
			user.setUserType(0);
			if (userDao.findUserById(user.getId()) != null)
				userDao.modifyUser(user);
			else {
				userDao.AddUser(user);
			}
		}
	}

	@Override
	public void modifyEmployee(Employee employee) {
		employeeDao.modifyEmployee(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.modifyEmployee(employee);
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		return (Employee) employeeDao.findEmployeeById(id);
	}

	@Override
	public List<Employee> findEmployeesByName(String name) {
		return (List<Employee>) employeeDao.findEmployeesByName(name);
	}

	@Override
	public List<Employee> findEmployeesByDepartment(String department) {
		return (List<Employee>) employeeDao
				.findEmployeesByDepartment(department);
	}
}
