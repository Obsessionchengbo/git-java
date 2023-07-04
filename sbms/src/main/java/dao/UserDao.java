package dao;

/*
* dao层
* */

import bean.User;

import java.util.ArrayList;

public interface UserDao {
    //查询所有用户
    ArrayList<User> userSelect();

    //根据uid查询用户
    User userSelectByUid(Integer uid);

    //增加用户
    int userInsert(User user);

    //删除用户
    int userDelete(Integer uid);

    //更新用户
    int userUpdate(User user);

}
