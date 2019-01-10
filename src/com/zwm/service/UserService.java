package com.zwm.service;

import com.zwm.pojo.User;

import java.util.List;


public interface UserService {
    /**
     *@methodName checkUserLoginService
     *@description //TODO 检验用户登录信息
     *
     *@param [uname, pwd]
     *@return com.zwm.pojo.User
     *@author zhangweiming
     *@date 16:54 2019/1/2
     */
    User checkUserLoginService(String uname, String pwd);
    /**
     *@methodName userChangePwdService
     *@description //TODO 修改用户登录密码
     *
     *@param [newPwd, uid]
     *@return int
     *@author zhangweiming
     *@date 18:15 2019/1/4
     */
    int userChangePwdService(String newPwd, int uid);

    /**
     *@methodName userShowService
     *@description //TODO 获取所有用户信息
     *
     *@param []
     *@return java.util.List<com.zwm.pojo.User>
     *@author zhangweiming
     *@date 19:28 2019/1/4
     */
    List<User> userShowService();
}
