package daoImpl;

import bean.BorrowInformation;
import dao.BorrowInformationDao;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings("all")
public class BorrowInformationDaoImpl implements BorrowInformationDao {
    @Override
    public ArrayList<BorrowInformation> borrowInformationSelect() {
        ArrayList<BorrowInformation> list = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = utils.JDBCUtils.getConnect();
            //3.获取执行者对象
            stat = conn.createStatement();

            //4.执行sql语句，并且接收返回的结果集
            String sql = "SELECT * FROM borrow_information";
            rs = stat.executeQuery(sql);

            //5.处理结果集
            while (rs.next()) {
                Integer buid = rs.getInt("buid");
                Integer uid = rs.getInt("uid");
                Integer bid = rs.getInt("bid");
                Timestamp borrowTime = rs.getTimestamp("borrow_time");
                Integer status = rs.getInt("status");
                Timestamp returnTime = rs.getTimestamp("return_time");
                Float amercement = rs.getFloat("amercement");

                //封装Student对象
                BorrowInformation borrowInformation = new BorrowInformation(buid,uid,bid,borrowTime,status,returnTime,amercement);

                //将student对象保存到集合中
                list.add(borrowInformation);
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

    @Override
    public BorrowInformation borrowInformationSelectBuid(Integer id) {
        BorrowInformation borrowInformation = new BorrowInformation();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = utils.JDBCUtils.getConnect();
            String sql = "SELECT * FROM borrow_information WHERE buid=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            System.out.println(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                Integer buid = rs.getInt("buid");
                Integer uid = rs.getInt("uid");
                Integer bid = rs.getInt("bid");
                Timestamp borrowTime = rs.getTimestamp("borrow_time");
                Integer status = rs.getInt("status");
                Timestamp returnTime = rs.getTimestamp("return_time");
                Float amercement = rs.getFloat("amercement");

                //封装借书记录对象
                borrowInformation.setBuid(buid);
                borrowInformation.setUid(uid);
                borrowInformation.setBid(bid);
                borrowInformation.setBorrowTime(borrowTime);
                borrowInformation.setStatus(status);
                borrowInformation.setReturnTime(returnTime);
                borrowInformation.setAmercement(amercement);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(conn, pst, rs);
        }
        //将对象返回
        return borrowInformation;
    }

    @Override
    public int borrowInformationInsert(BorrowInformation borrowInformation) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = utils.JDBCUtils.getConnect();
            String sql = "insert into borrow_information values (?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setObject(1, borrowInformation.getBuid());
            pst.setObject(2, borrowInformation.getUid());
            pst.setObject(3, borrowInformation.getBid());
            pst.setObject(4,borrowInformation.getBorrowTime());
            pst.setObject(5, borrowInformation.getStatus());
            pst.setObject(6,borrowInformation.getReturnTime());
            pst.setObject(7, borrowInformation.getAmercement());
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.JDBCUtils.close(con, pst, null);
        }
        return result;
    }

    @Override
    public int borrowInformationDelete(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = utils.JDBCUtils.getConnect();
            String sql = "delete from borrow_information where buid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.JDBCUtils.close(con, pst, null);
        }
        return result;
    }

    @Override
    public int borrowInformationUpdate(BorrowInformation borrowInformation) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = utils.JDBCUtils.getConnect();
            String sql = "update borrow_information set uid=?,bid=?,borrow_time=?,status=?,returm_time=?,amercement=? where buid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, borrowInformation.getUid());
            pst.setInt(2, borrowInformation.getBid());
            pst.setTimestamp(3,borrowInformation.getBorrowTime());
            pst.setInt(4, borrowInformation.getStatus());
            pst.setTimestamp(5, borrowInformation.getReturnTime());
            pst.setFloat(6,borrowInformation.getAmercement());
            pst.setInt(7, borrowInformation.getBuid());
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.JDBCUtils.close(con, pst, null);
        }
        return result;
    }
}
