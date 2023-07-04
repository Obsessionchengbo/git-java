package dao;

import bean.Book;

import java.util.ArrayList;

/*
dao层
* */

public interface BookDao {
    //查询所有书籍
    ArrayList<Book> bookSelectAll();

    //根据bid查询书籍
    Book bookSelectByBid(Integer bid);

    //增加书籍
    int bookInsert(Book book);

    //删除书籍
    int bookDelete(Integer bid);

    //更新书籍
    int bookUpdate(Book book);

}
