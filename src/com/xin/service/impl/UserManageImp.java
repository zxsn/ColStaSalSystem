package com.xin.service.impl;

import javax.annotation.Resource;

import com.xin.dao.IUserDao;
import com.xin.bean.User;
import com.xin.security.Md5;
import com.xin.service.IUserManage;
/**
 * 
    * @ClassName: UserManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class UserManageImp implements IUserManage {
	
	@Resource  
	private IUserDao userDao;
	
	public IUserDao getUserDao() {	
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		user.setPassword(Md5.generatePassword(user.getPassword()));
		userDao.AddUser(user);
	}

	@Override
	public void modifyUser(User user) {
		user.setPassword(Md5.generatePassword(user.getPassword()));
		userDao.modifyUser(user);
	}

	@Override
	public void deleteUser(User user) {		
		userDao.deleteUser(user);
	}

	@Override
	public User findUserById(Integer id) {
		return userDao.findUserById(id);
	}

}
