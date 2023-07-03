import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class dataBase {
    static String url1 = "jdbc:mysql:///library _system?useSSL=false&useServerPrepStmts=true";
    static String username = "root";
    static String usepassword = "123456";
    static Connection connection;

    //编译时运行,连接数据库仅用一个即可
    static {
        try {
            connection = DriverManager.getConnection(url1, username, usepassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static Scanner sc = new Scanner(System.in);

    //注册功能
    public static boolean register(int id, int password, String position, String name) throws Exception {
        Connection conn = con();
        boolean flag = true;
        if (position.equals("学生")) {
            String sql = "insert into student(id,password,name)values(?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, password);
            pst.setString(3, name);
            int i = pst.executeUpdate();
            if (i == 1) {
            } else flag = false;
            pst.close();


            String sql1 = "insert into borrow_table(id,position,borrownum)values(?,?,5)";
            PreparedStatement pst1 = connection.prepareStatement(sql1);
            pst1.setInt(1, id);
            pst1.setString(2, position);
            int j = pst1.executeUpdate();
            if (j == 1) {
            }
            pst1.close();

        } else {
            String sql3 = "insert into teacher(id,password,position,name)values(?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql3);
            pst.setInt(1, id);
            pst.setInt(2, password);
            pst.setString(3, position);
            pst.setString(4, name);
            int i = pst.executeUpdate();
            if (i == 1) {
            } else flag = false;
            pst.close();


            String sql2 = "insert into borrow_table(id,position,borrownum)values(?,?,?)";
            PreparedStatement pst2 = connection.prepareStatement(sql2);
            pst2.setInt(1, id);
            pst2.setString(2, position);
            pst2.setInt(3, made(position));
            int j = pst2.executeUpdate();
            if (j == 1) {
            }
            pst2.close();
            conn.close();
        }
        return flag;
    }

    //老师学生登录功能
    public static boolean log(int rid, int rpassword, int num) throws Exception {
        Connection conn = con();
        boolean flag = false;
        if (num == 1) {
            String sql = "select id,password from student where id=? and password=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, rid);
            pst.setInt(2, rpassword);
            ResultSet rs1 = pst.executeQuery();
            while (rs1.next()) {
                int sid = rs1.getInt("id");
                int spassword = rs1.getInt("password");
                if (sid == rid && spassword == rpassword) {
                    flag = true;
                }
            }
            rs1.close();

        } else if (num == 0) {
            String sql1 = "select id,password from teacher where id=? and password=?";
            PreparedStatement pst1 = connection.prepareStatement(sql1);
            pst1.setInt(1, rid);
            pst1.setInt(2, rpassword);
            ResultSet rs = pst1.executeQuery();
            while (rs.next()) {
                int tid = rs.getInt("id");
                int tpassword = rs.getInt("password");
                if (tid == rid && tpassword == rpassword) {
                    flag = true;
                }
            }
            rs.close();
        } else
            flag = false;
        conn.close();
        return flag;
    }

    //管理员登录功能
    public static boolean admLog(int id, int password) throws Exception {
        Connection conn = con();
        boolean flag = false;
        String sql = "select id,password from administrator where id=? and password=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        pst.setInt(2, password);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int rid = rs.getInt("id");
            int rpassword = rs.getInt("password");
            if (rid == id && rpassword == password) {
                flag = true;
            }
        }
        rs.close();
        conn.close();
        return flag;
    }

    //借书功能
    public static void borrowBook(int id, String bookname) throws Exception {
        Connection conn = con();
        String sql = "select * from books where bookname=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, bookname);
        ResultSet rs = pst.executeQuery();
        if (!rs.next()) {
            System.out.println("查无此书,请重新输入");
            return;
        }
        int count = rs.getInt("count");
        if (count == 0) {
            System.out.println("此书被借空了");
            return;
        }

        rs.close();
        pst.close();

        String sql1 = "update books set count=count-1 where bookname=?";
        PreparedStatement pst1 = connection.prepareStatement(sql1);
        pst1.setString(1, bookname);
        pst1.executeUpdate();
        pst1.close();

        String sql2 = "update book_type set typecount=typecount-1 where booktype=?";
        PreparedStatement pst2 = connection.prepareStatement(sql2);
        pst2.setString(1, madeBook(bookname));
        pst2.executeUpdate();
        pst2.close();

        String sql3 = "update borrow_table set borrownum=borrownum-1 where id=?";
        PreparedStatement pst3 = connection.prepareStatement(sql3);
        pst3.setInt(1, id);
        pst3.executeUpdate();
        pst3.close();

        String sql4 = "insert into borrow(id,bookname,state)values(?,?,'借书')";
        PreparedStatement pst4 = connection.prepareStatement(sql4);
        pst4.setInt(1, id);
        pst4.setString(2, bookname);
        int k = pst4.executeUpdate();
        if (k == 1) {
            System.out.println("借阅成功！");
        }
        pst4.close();
        conn.close();
    }

    //还书功能
    public static void returnBook(int id, String bookname) throws Exception {
        Connection conn = con();
        String sql = "select * from books where bookname=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, bookname);
        ResultSet rs = pst.executeQuery();
        if (!rs.next()) {
            System.out.println("查无此书");
            return;
        }
        rs.close();
        pst.close();

        String sql1 = "update books set count=count+1 where bookname=?";
        PreparedStatement pst1 = connection.prepareStatement(sql1);
        pst1.setString(1, bookname);
        pst1.executeUpdate();
        pst1.close();

        String sql2 = "update book_type set typecount=typecount+1 where booktype=?";
        PreparedStatement pst2 = connection.prepareStatement(sql2);
        pst2.setString(1, madeBook(bookname));
        pst2.executeUpdate();
        pst2.close();

        String sql3 = "update borrow_table set borrownum=borrownum+1 where id=?";
        PreparedStatement pst3 = connection.prepareStatement(sql3);
        pst3.setInt(1, id);
        pst3.executeUpdate();
        pst3.close();

        String sql4 = "insert into borrow(id,bookname,state)values(?,?,'还书')";
        PreparedStatement pst4 = connection.prepareStatement(sql4);
        pst4.setInt(1, id);
        pst4.setString(2, bookname);
        int k = pst4.executeUpdate();
        if (k == 1) {
            System.out.println("还书成功！");
        }
        pst4.close();

        conn.close();
    }

    //查阅信息功能
    public static void view() throws Exception {
        Connection conn = con();
        String sql = "select *from books";
        PreparedStatement pst4 = connection.prepareStatement(sql);
        ResultSet rs = pst4.executeQuery();
        System.out.println("booknum" + "  " + "bookname" + "  " + "count" + "   " + "booktype");
        while (rs.next()) {
            int booknum = rs.getInt("booknum");
            String bookname = rs.getString("bookname");
            int count = rs.getInt("count");
            String booktype = rs.getString("booktype");
            System.out.print(booknum);
            System.out.print("    " + bookname);
            System.out.print("     " + count);
            System.out.print("     " + booktype);
            System.out.println();
        }
        rs.close();
        pst4.close();
        conn.close();
    }

    //管理员添加图书功能
    public static void add(int booknumber, String bookname, int count, String booktype) throws Exception {
        Connection conn = con();
        String sql = "insert into books(booknum,bookname,count,booktype)values(?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, booknumber);
        pst.setString(2, bookname);
        pst.setInt(3, count);
        pst.setString(4, booktype);
        int k = pst.executeUpdate();
        if (k == 1) {
            System.out.println("添加图书成功");
        }
        pst.close();

        //判断有没有这个类型的图书     有的话直接加上添加进来的图书
        //如果没有 要新添加进来图书类型和数量

        String sql2 = "select booktype from book_type where booktype=?";
        PreparedStatement pst2 = conn.prepareStatement(sql2);
        pst2.setString(1, booktype);
        ResultSet rs = pst2.executeQuery();
        boolean b = false;
        b = rs.next();
        judge(count, booktype, b);

        rs.close();
        pst2.close();
        conn.close();
    }

    //管理员更改图书功能
    public static void change(int booknum) throws Exception {
        int count;
        String type;
        int num;
        Connection conn = con();
        String sql = "update books set booknum=?,bookname=?,count=?,booktype=? where booknum=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        System.out.println("请输入更改后的图书编号");
        num = sc.nextInt();
        pst.setInt(1, num);
        System.out.println("请输入更改后的图书名");
        pst.setString(2, sc.next());
        System.out.println("请输入更改后的图书数量");
        pst.setInt(3, sc.nextInt());
        System.out.println("请输入更改后的图书类型");
        pst.setString(4, sc.next());
        pst.setInt(5, booknum);
        pst.executeUpdate();
        pst.close();

        String sql1 = "select count,booktype from books where booknum=?";
        PreparedStatement pst1 = conn.prepareStatement(sql1);
        pst1.setInt(1, num);
        ResultSet rs = pst1.executeQuery();
        boolean b = false;
        b = rs.next();
        count = rs.getInt("count");
        type = rs.getString("booktype");
        judge(count, type, b);
        rs.close();
        pst1.close();

        conn.close();
    }

    //管理员删除图书功能
    public static void delete(int booknum) throws Exception {
        int count;
        String type;
        Connection conn = con();
        String sql = "select * from books where booknum=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, booknum);
        ResultSet rs = pst.executeQuery();
        if (!rs.next()) {
            System.out.println("查无此书,请重新输入");
            return;
        }
        rs.close();
        pst.close();

        String sql1 = "select count,booktype from books where booknum=?";
        PreparedStatement pst1 = connection.prepareStatement(sql1);
        pst1.setInt(1, booknum);
        ResultSet rs1 = pst1.executeQuery();
        boolean b = rs1.next();
        count = rs1.getInt("count");
        type = rs1.getString("booktype");
        rs1.close();
        pst1.close();

        String sql2 = "delete from books where booknum=?";
        PreparedStatement pst2 = connection.prepareStatement(sql2);
        pst2.setInt(1, booknum);
        pst2.executeUpdate();
        pst2.close();

        String sql3 = "update book_type set typecount=typecount-? where booktype=?";
        PreparedStatement pst3 = connection.prepareStatement(sql3);
        pst3.setInt(1, count);
        pst3.setString(2, type);
        int i = pst3.executeUpdate();
        if (i == 1) {
            System.out.println("删除成功！");
        }
        pst3.close();
        conn.close();
    }

    //获取教师各个职位所能借阅的书籍数量
    public static int made(String position) {
        Map<String, Integer> map = new HashMap<>();
        map.put("教授", 10);
        map.put("副教授", 10);
        map.put("讲师", 8);
        map.put("助教", 6);
        return map.get(position);
    }

    //获取图书类型
    public static String madeBook(String bookname) throws Exception {
        String sql = "select booktype from books where bookname=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, bookname);
        ResultSet rs = pst.executeQuery();
        String type = null;
        while (rs.next()) {
            type = rs.getString("booktype");
        }
        rs.close();
        return type;
    }

    //判断图书类型是否有
    public static boolean judge(int count, String booktype, boolean flag) throws Exception {
        PreparedStatement pst;
        String sql;
        if (flag) {
            sql = "update  book_type set typecount=typecount+? where booktype=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, count);
            pst.setString(2, booktype);
        } else {
            sql = "insert into book_type(booktype,typecount)values(?,?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, booktype);
            pst.setInt(2, count);
        }
        int i = pst.executeUpdate();
        pst.close();
        return i == 1;
    }

    public static Connection con() throws Exception {
        connection = DriverManager.getConnection(url1, username, usepassword);
        return connection;
    }

}
