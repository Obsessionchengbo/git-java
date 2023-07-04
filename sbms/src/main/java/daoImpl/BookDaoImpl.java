package daoImpl;

import bean.Book;
import dao.BookDao;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class BookDaoImpl implements BookDao {
    @Override//查询所有书籍
    public ArrayList<Book> bookSelectAll() {
        ArrayList<Book> list = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = utils.JDBCUtils.getConnect();
            //3.获取执行者对象
            stat = conn.createStatement();

            //4.执行sql语句，并且接收返回的结果集
            String sql = "SELECT * FROM book";
            rs = stat.executeQuery(sql);

            //5.处理结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                String press = rs.getString("press");
                String synopsis = rs.getString("synopsis");
                String bookType = rs.getString("book_type");
                Float price = rs.getFloat("price");
                Integer count = rs.getInt("count");

                //封装Student对象
                Book book = new Book(bid, bookName, author, press, synopsis, bookType, price, count);

                //将student对象保存到集合中
                list.add(book);
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

    @Override//条件查询书籍
    public Book bookSelectByBid(Integer id) {
        Book book = new Book();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = utils.JDBCUtils.getConnect();
            String sql = "SELECT * FROM book WHERE bid=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            System.out.println(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                Integer bid = rs.getInt("bid");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                String press = rs.getString("press");
                String synopsis = rs.getString("synopsis");
                String bookType = rs.getString("book_type");
                Float price = rs.getFloat("price");
                Integer count = rs.getInt("count");


                //封装书籍对象
                book.setBid(bid);
                book.setBookName(bookName);
                book.setAuthor(author);
                book.setPress(press);
                book.setSynopsis(synopsis);
                book.setBookType(bookType);
                book.setPrice(price);
                book.setCount(count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(conn, pst, rs);
        }
        //将对象返回
        return book;
    }

    @Override//新增书籍
    public int bookInsert(Book book) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = utils.JDBCUtils.getConnect();
            String sql = "insert into book value (?, ?, ?, ?, ?, ?, ?, ?);";
            pst = con.prepareStatement(sql);
            pst.setInt(1, book.getBid());
            pst.setString(2, book.getBookName());
            pst.setString(3, book.getAuthor());
            pst.setString(4, book.getPress());
            pst.setString(5, book.getSynopsis());
            pst.setString(6, book.getBookType());
            pst.setFloat(7, book.getPrice());
            pst.setInt(8, book.getCount());
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.JDBCUtils.close(con, pst, null);
        }
        return result;
    }

    @Override//删除书籍
    public int bookDelete(Integer bid) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = utils.JDBCUtils.getConnect();
            String sql = "delete from book where bid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, bid);
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.JDBCUtils.close(con, pst, null);
        }
        return result;
    }

    @Override//更新书籍信息
    public int bookUpdate(Book book) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = utils.JDBCUtils.getConnect();
            String sql = "update book set book_name=?,author=?,press=?,synopsis=?,book_type=?,price=?,count=? where bid=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, book.getBookName());
            pst.setString(2, book.getAuthor());
            pst.setString(3, book.getPress());
            pst.setString(4, book.getSynopsis());
            pst.setString(5, book.getBookType());
            pst.setFloat(6, book.getPrice());
            pst.setInt(7, book.getCount());
            pst.setInt(8, book.getBid());
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.JDBCUtils.close(con, pst, null);
        }
        return result;
    }
}
