package com.xin.dao;

import com.xin.bean.User;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IUserDao {
	public void AddUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
	public User findUserById(Integer id);
}
