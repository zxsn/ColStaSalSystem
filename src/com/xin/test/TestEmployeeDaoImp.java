package com.xin.test;



import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.xin.dao.IEmployeeDao;
import com.xin.dao.impl.EmployeeDaoImp;
import com.xin.bean.Employee;

public class TestEmployeeDaoImp {
	 public static IEmployeeDao iemployeeDao;
	 
	@SuppressWarnings("resource")
	@BeforeClass
	public static void setUp() {
		iemployeeDao = new EmployeeDaoImp();
		ApplicationContext ctx = new  FileSystemXmlApplicationContext("/config/applicationContext-beans.xml"); 
		iemployeeDao = (IEmployeeDao) ctx.getBean("employeeDao");
	}


	@SuppressWarnings("unused")
	@Test
	public void testFindEmployeeById() {
	Employee employee = iemployeeDao.findEmployeeById(113311);
	}

	@Test
	public void testAddEmployee() {
		
	}

	@Test
	public void testDeleteEmployee() {

	}

	@Test
	public void testModifyEmployee() {

	}

}
