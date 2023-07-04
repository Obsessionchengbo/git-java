package dao;

import bean.BorrowInformation;
import bean.UserType;

import java.util.ArrayList;

@SuppressWarnings("all")
public interface UserTypeDao {
    //查询所有用户类型
    ArrayList<UserType> userTypeSelect();

    //根据utid查询类型
    UserType userTypeSelectUtid(Integer id);

    //增加书籍
    int userTypeInsert(UserType userType);

    //删除书籍
    int userTypeDelete(Integer utid);

    //更新书籍
    int userTypeUpdate(UserType userType);
}
