package daoImpl;

import bean.UserType;
import dao.UserTypeDao;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@SuppressWarnings("all")
public class UserTypeDaoImpl implements UserTypeDao {
    @Override//查询用户类型表
    public ArrayList<UserType> userTypeSelect() {
        ArrayList<UserType> list = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = utils.JDBCUtils.getConnect();
            //3.获取执行者对象
            stat = conn.createStatement();

            //4.执行sql语句，并且接收返回的结果集
            String sql = "SELECT * FROM user_type";
            rs = stat.executeQuery(sql);

            //5.处理结果集
            while (rs.next()) {
                Integer utid = rs.getInt("utid");
                String position = rs.getString("position");
                Integer maxCount = rs.getInt("password");


                //封装Student对象
                UserType userType = new UserType(utid, position, maxCount);

                //将student对象保存到集合中
                list.add(userType);
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

    @Override//条件查询用户类型表
    public UserType userTypeSelectUtid(Integer id) {
        UserType userType = new UserType();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = utils.JDBCUtils.getConnect();
            String sql = "SELECT * FROM user_type WHERE utid=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            //System.out.println(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                Integer utid = rs.getInt("utid");
                String position = rs.getString("position");
                Integer maxCount = rs.getInt("max_count");
                //封装UserType对象
                userType.setUtid(utid);
                userType.setPosition(position);
                userType.setMaxCount(maxCount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            utils.JDBCUtils.close(conn, pst, rs);
        }
        //将对象返回
        return userType;
    }

    @Override//新增用户类型表
    public int userTypeInsert(UserType userType) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = utils.JDBCUtils.getConnect();
            String sql = "insert into user_type value (?, ?, ?);";
            pst = con.prepareStatement(sql);
            pst.setInt(1, userType.getUtid());
            pst.setString(2, userType.getPosition());
            pst.setInt(3, userType.getMaxCount());
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.JDBCUtils.close(con, pst, null);
        }
        return result;
    }

    @Override//删除用户类型表
    public int userTypeDelete(Integer utid) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = utils.JDBCUtils.getConnect();
            String sql = "delete from user_type where utid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, utid);
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.JDBCUtils.close(con, pst, null);
        }
        return result;
    }

    @Override//更新用户类型表
    public int userTypeUpdate(UserType userType) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = JDBCUtils.getConnect();
            String sql = "update user_type set position=?,max_count=? where utid=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, userType.getPosition());
            pst.setInt(2, userType.getMaxCount());
            pst.setInt(3, userType.getUtid());
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pst, null);
        }
        return result;
    }
}
