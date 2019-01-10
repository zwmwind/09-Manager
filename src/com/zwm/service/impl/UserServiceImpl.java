package com.zwm.service.impl;

import com.zwm.dao.UserDao;
import com.zwm.dao.impl.UserDaoImpl;
import com.zwm.pojo.User;
import com.zwm.service.UserService;
import org.apache.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements UserService {
    //声明日志对象
    Logger logger = Logger.getLogger(UserServiceImpl.class);
    //声明Dao层对象
    UserDao ud = new UserDaoImpl();
    //用户登录
    @Override
    public User checkUserLoginService(String uname, String pwd) {
        //打印日志
        logger.debug(uname + "发起了登录请求");
        User u = ud.checkUserLoginDao(uname, pwd);
        //判断
        if (u != null) {
            logger.debug(uname + "登录成功");
        }else {
            logger.debug(uname + "登录失败");
        }
        return u;
    }

    //修改用户密码
    @Override
    public int userChangePwdService(String newPwd, int uid) {
        logger.debug(uid + "发起密码修改");
        int index = ud.userChangePwdDap(newPwd, uid);
        if (index > 0){
            logger.debug(uid + ":密码修改成功");
        } else {
            logger.debug(uid + ":密码修改失败");
        }
        return index;
    }

    //获取所有的用户信息
    @Override
    public List<User> userShowService() {
        List<User> lu = ud.userShowDao();
        logger.debug("显示所有用户的信息：" + lu);
        return lu;
    }
}
