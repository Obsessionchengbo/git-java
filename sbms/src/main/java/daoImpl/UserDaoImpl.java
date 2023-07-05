package daoImpl;

import bean.User;
import dao.UserDao;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

//@SuppressWarnings("all")
public class UserDaoImpl implements UserDao {
    @Override//查询所有用户
    public ArrayList<User> userSelect() {
        ArrayList<User> list = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = utils.JDBCUtils.getConnect();
            //3.获取执行者对象
            stat = conn.createStatement();

            //4.执行sql语句，并且接收返回的结果集
            String sql = "SELECT * FROM user";
            rs = stat.executeQuery(sql);

            //5.处理结果集
            while (rs.next()) {
                Integer uid = rs.getInt("uid");
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                Integer age = rs.getInt("age");
                Integer userType = rs.getInt("user_type");
                Float balance = rs.getFloat("balance");

                //封装用户对象
                User user = new User(uid, userName, password, name, sex, age, userType, balance);

                //将用户对象保存到集合中
                list.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            JDBCUtils.close(conn, stat, rs);
        }
        //将集合对象返回
        return list;
    }

    @Override//条件查询用户
    public User userSelectByUid(Integer id) {
        User user = new User();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = utils.JDBCUtils.getConnect();
            String sql = "SELECT * FROM user WHERE uid=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            //System.out.println(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                Integer uid = rs.getInt("uid");
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                Integer age = rs.getInt("age");
                Integer userType = rs.getInt("user_type");
                Float balance = rs.getFloat("balance");


                //封装User对象
                user.setUid(uid);
                user.setUserName(userName);
                user.setPassword(password);
                user.setName(name);
                user.setSex(sex);
                user.setAge(age);
                user.setUserType(userType);
                user.setBalance(balance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            utils.JDBCUtils.close(conn, pst, rs);
        }
        //将对象返回
        return user;
    }

    @Override//新增用户
    public int userInsert(User user) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = utils.JDBCUtils.getConnect();
            String sql = "insert into user value ( ?,?, ?, ?, ?, ?, ?,?);";
            pst = con.prepareStatement(sql);
            pst.setInt(1, user.getUid());
            pst.setString(2, user.getUserName());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getName());
            pst.setString(5, user.getSex());
            pst.setInt(6, user.getAge());
            pst.setInt(7, user.getUserType());
            pst.setFloat(8, user.getBalance());
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.JDBCUtils.close(con, pst, null);
        }
        return result;
    }

    @Override//删除用户
    public int userDelete(Integer uid) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = utils.JDBCUtils.getConnect();
            String sql = "delete from user where uid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, uid);
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.JDBCUtils.close(con, pst, null);
        }
        return result;
    }

    @Override//更新用户
    public int userUpdate(User user) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = JDBCUtils.getConnect();
            String sql = "update user set user_name=?,password=?,name=?,sex=?,age=?,user_type=?,balance=? where uid=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getName());
            pst.setString(4, user.getSex());
            pst.setInt(5, user.getAge());
            pst.setInt(6, user.getUserType());
            pst.setFloat(7, user.getBalance());
            pst.setInt(8, user.getUid());
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pst, null);
        }
        return result;
    }
}
