package com.zwm.dao;

import com.zwm.pojo.User;

import java.util.List;

public interface UserDao {
    /**
     *@methodName checkUserLoginDao
     *@description //TODO 根据用户名和密码查询用户信息
     *
     *@param [uname, pwd]
     *@return com.zwm.pojo.User
     *@author zhangweiming
     *@date 16:56 2019/1/2
     */
    User checkUserLoginDao(String uname, String pwd);

    /**
     *@methodName userChangePwdDap
     *@description //TODO 根据新密码和Uid修改用户个人密码
     *
     *@param [newPwd, uid]
     *@return int
     *@author zhangweiming
     *@date 18:16 2019/1/4
     */
    int userChangePwdDap(String newPwd, int uid);

    /**
     *@methodName userShowDao
     *@description //TODO 获取所有用户的信息
     *
     *@param []
     *@return java.util.List<com.zwm.pojo.User>
     *@author zhangweiming
     *@date 19:29 2019/1/4
     */
    List<User> userShowDao();

    /**
     *@methodName useRegDao
     *@description //TODO 用户注册
     *
     *@param [u]
     *@return int
     *@author zhangweiming
     *@date 18:08 2019-01-11
     */
    int useRegDao(User u);
}
