package com.xin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.xin.bean.User;
import com.xin.exception.ExcelException;

public class ImportAndExport {

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) throws FileNotFoundException, ExcelException {
		System.out.println(System.getProperty("user.dir"));
		String path = "document\\user.xls";
		List<User> userList = new ArrayList<User>();
		InputStream in = new FileInputStream(new File(path));
		LinkedHashMap fieldMap = new LinkedHashMap<String, String>();
		fieldMap.put("职工号", "id");
		fieldMap.put("密码", "password");
		fieldMap.put("类型", "userType");
		String[] uniqueFields = {"职工号"};
		User user = new User();
		userList = ExcelUtil.excelToList(in, "Sheet1", User.class, fieldMap, uniqueFields);
		for (User u : userList) {
			System.out.println("_____________________华丽的昏割线_______________________");
			System.out.println(u.getId());
			System.out.println(u.getPassword());
			System.out.println(u.getUserType());
		}
	}

}
