import bean.Book;
import bean.BorrowInformation;
import bean.User;
import bean.UserType;
import dao.BorrowInformationDao;
import daoImpl.BookDaoImpl;
import daoImpl.BorrowInformationDaoImpl;
import daoImpl.UserDaoImpl;
import daoImpl.UserTypeDaoImpl;
import org.junit.Test;

import java.sql.Timestamp;

public class Test01 {

    @Test
    public void testUser() {//测试用户
        UserDaoImpl user = new UserDaoImpl();
        User user1 = new User(10004,"haohuang2","123456","黄浩","男",20,1,1F);
        System.out.println(user.userSelectByUid(10001));
        //测试新增功能
        /*if (user.UserInsert(user1) == 1) {
            System.out.println("新增成功!");
        } else {
            System.out.println("新增失败!");
        }*/

        //测试更新功能
        /*if(user.UserUpdate(user1) == 1){
            System.out.println("更新成功!");
        }else {
            System.out.println("更新失败!");
        }*/

        //测试删除功能
        if (user.userDelete(10004) == 1) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败!");
        }
    }

    @Test
    public void testBook() {
        BookDaoImpl book = new BookDaoImpl();
        Book book1 = new Book(20230020, "天空的城", "坦克", "广东人民出版社", "昭阳和四个女人的爱恨情仇", "现代小说(小说)", 45.5F, 5);
        System.out.println(book.bookSelectByBid(20230007));
        //测试新增功能
        /*if (book.BookInsert(book1) == 1) {
            System.out.println("新增成功!");
        } else {
            System.out.println("新增失败!");
        }*/

        //测试更新功能
        /*if(book.BookUpdate(book1) == 1){
            System.out.println("更新成功!");
        }else {
            System.out.println("更新失败!");
        }*/

        //测试删除功能
        /*if (book.BookDelete(20230021) == 1) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败!");
        }*/
    }

    @Test
    public void testBorrowInformation(){
        BorrowInformationDaoImpl borrowInformation = new BorrowInformationDaoImpl();
        BorrowInformation borrowInformation1 = new BorrowInformation(3,10003,20230011,new Timestamp(System.currentTimeMillis()),0,null,0F);
        System.out.println(borrowInformation.borrowInformationSelectBuid(1));
        //测试新增功能
        if (borrowInformation.borrowInformationInsert(borrowInformation1) > 0) {
            System.out.println("新增成功!");
        } else {
            System.out.println("新增失败!");
        }
    }

    @Test
    public void testUserType(){
        UserTypeDaoImpl userType = new UserTypeDaoImpl();
        UserType userType1 = new UserType();
        System.out.println(userType.userTypeSelectUtid(1));
        //测试新增功能
        /*if (book.BookInsert(book1) == 1) {
            System.out.println("新增成功!");
        } else {
            System.out.println("新增失败!");
        }*/

        //测试更新功能
        /*if(book.BookUpdate(book1) == 1){
            System.out.println("更新成功!");
        }else {
            System.out.println("更新失败!");
        }*/

        //测试删除功能
        /*if (book.BookDelete(20230021) == 1) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败!");
        }*/
    }

}
