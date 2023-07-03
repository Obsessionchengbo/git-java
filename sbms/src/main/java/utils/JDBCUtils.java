package utils;

import lombok.NoArgsConstructor;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*
JDBC工具类
* */

@NoArgsConstructor
@SuppressWarnings("")
public class JDBCUtils {

    //声明所需要的配置变量
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;
    private static Connection con;

    //静态码块,读取配置文件信息为变量赋值,注册驱动
    static {
        try {
            //赋值
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("resources\\druid.properties");
            Properties pro = new Properties();
            pro.load(is);
            driverClass = pro.getProperty("driverClass");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
            //注册
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接
    public static Connection getConnect() {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //关闭连接
    public static void close(Connection con, Statement state, ResultSet rs) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(state != null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


