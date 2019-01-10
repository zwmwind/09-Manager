package com.zwm.dao.impl;

import com.zwm.dao.UserDao;
import com.zwm.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //根据用户名和密码查询用户信息
    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明变量
        User u = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","zwm1995731");
            //创建sql命令
            String sql = "select * from t_user where uname=? and pwd=?";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, uname);
            ps.setString(2, pwd);
            //执行sql
            rs = ps.executeQuery();
            //遍历结果
            while(rs.next()) {
                //给变量赋值
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setAge(rs.getInt("age"));
                u.setSex(rs.getInt("sex"));
                u.setBirth(rs.getString("birth"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {//关闭资源
            try {
                if (rs !=null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回结果
        return u;
    }

    @Override
    public int userChangePwdDap(String newPwd, int uid) {
        //声明JDBC变量
        Connection conn = null;
        PreparedStatement ps = null;
        //创建变量
        int index = -1;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","zwm1995731");
            //创建sql命令
            String sql = "update t_user set pwd=? where uid=?";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, newPwd);
            ps.setInt(2, uid);
            //执行
            index = ps.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //返回结果
        return index;
    }

    //获取所有的用户信息
    @Override
    public List<User> userShowDao() {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明变量
        List<User> lu = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","zwm1995731");
            //创建sql命令
            String sql = "select * from t_user";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //执行sql
            rs = ps.executeQuery();
            //给集合赋值
            lu = new ArrayList<>();
            //遍历结果
            while(rs.next()) {
                //给变量赋值
                User u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setAge(rs.getInt("age"));
                u.setSex(rs.getInt("sex"));
                u.setBirth(rs.getString("birth"));
                //将对象存储到集合中
                lu.add(u);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {//关闭资源
            try {
                if (rs !=null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回结果
        return lu;
    }
}
