package dao;

import bean.Book;
import bean.BorrowInformation;
import bean.User;

import java.util.ArrayList;

public interface BorrowInformationDao {
    //查询所有借书记录
    ArrayList<BorrowInformation> borrowInformationSelect();

    //根据bid查询借书记录
    BorrowInformation borrowInformationSelectBuid(Integer buid);

    //增加书籍
    int borrowInformationInsert(BorrowInformation borrowInformation);

    //删除书籍
    int borrowInformationDelete(Integer id);

    //更新书籍
    int borrowInformationUpdate(BorrowInformation borrowInformation);
}
