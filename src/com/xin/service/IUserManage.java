package com.xin.service;

import com.xin.bean.User;
/**
 * 
    * @ClassName: IUserManage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public interface IUserManage {
    public void addUser(User user);// 添加用户

    public void modifyUser(User user);// 修改用户

    public void deleteUser(User user);// 删除用户

    public User findUserById(Integer id);// 根据id查找用户
}
