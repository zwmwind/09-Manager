package com.zwm.servlet;

import com.zwm.pojo.User;
import com.zwm.service.UserService;
import com.zwm.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserServlet extends javax.servlet.http.HttpServlet {
    //获取service对象
    UserService us = new UserServiceImpl();
    //声明日志对象
    Logger logger = Logger.getLogger(UserService.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取操作符
        String oper = req.getParameter("oper");

        if ("login".equals(oper)) {
            //调用登录处理方法
            checkUserLogin(req, resp);
        }else if("reg".equals(oper)) {
            //调用注册功能
            userReg(req, resp);
        }else if("out".equals(oper)){
            //调用退出功能
            userOut(req, resp);
        }else if("pwd".equals(oper)){
            //调用修改密码功能
            userPwdChange(req, resp);
        }else if("show".equals(oper)){
            //调用查询所有用户功能
            userShow(req, resp);
        }else {
            //System.out.println("没有找到对应的操作符: " + oper);
            logger.debug("没有找到对应的操作符: " + oper);
        }
    }

    private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求
        //调用Service
        List<User> lu = us.userShowService();
        //判断
        if(lu != null) {
            //将查询的用户数据存储到request对象
            req.setAttribute("lu", lu);
            req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
            return;
        }
    }

    private void userPwdChange(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取数据
        String newPwd = req.getParameter("newPwd");
        //从Session中获取用户信息
        User u = (User)req.getSession().getAttribute("user");
        int uid = u.getUid();
        //System.out.println(uid + ":" + newPwd);
        //处理请求
        //调用Service处理
        int index = us.userChangePwdService(newPwd, uid);
        if (index > 0) {
            //获取Session对象
            HttpSession hs = req.getSession();
            hs.setAttribute("pwd", "true");
            //重定向到登录页面
            resp.sendRedirect("login.jsp");
        }

    }

    private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取Session对象
        HttpSession hs = req.getSession();
        //强制销毁Session
        hs.invalidate();
        //重定向到登录页面
        resp.sendRedirect("login.jsp");
    }


    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取请求信息
        String uname=  req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //获取请求信息

            //校验
            User u = us.checkUserLoginService(uname, pwd);
            if (u != null) {
                //获取Session对象
                HttpSession hs = req.getSession();
                //将用户数据存储到Session中
                hs.setAttribute("user", u);
                //重定向
                resp.sendRedirect("main/main.jsp");
            }else {
                //添加标识符到request中
                req.setAttribute("flag", 0);
                //请求转发
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
                return;
            }
        //直接响应


    }

    //注册用户
    private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求信息
            String uname = req.getParameter("uname");
            String pwd = req.getParameter("pwd");
            String sex = req.getParameter("sex");
            int age = req.getParameter("age")!=""?Integer.parseInt(req.getParameter("age")):0;
            String birth = req.getParameter("birth");
            String[] bs = null;
            if (birth!="") {
                bs = birth.split("/");
            }
            StringBuffer sb = new StringBuffer();
            sb.append(bs[2]);
            sb.append("/");
            sb.append(bs[0]);
            sb.append("/");
            sb.append(bs[1]);


            //System.out.println(uname+pwd+sex+age+birth);
            User u = new User(0, uname, pwd, sex, age, sb.toString());
        //处理请求信息
            //调用业务层处理
            int index = us.userRegService(u);
            //System.out.println(index);
        //响应请求信息
            if (index > 0) {
                //获取Session
                HttpSession hs = req.getSession();
                hs.setAttribute("reg", "true");
                //重定向
                resp.sendRedirect("login.jsp");
            }
    }

}
