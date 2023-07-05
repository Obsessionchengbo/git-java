package ui;

import daoImpl.BookDaoImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHandler6 implements ActionListener {

    private DeleteBookFace deleteBook;

    public LoginHandler6(DeleteBookFace deleteBook) {
        this.deleteBook = deleteBook;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("删除".equals(text)) {
            //DeleteBookJDBC deleteBookJDBC = new DeleteBookJDBC();
            // 获取 bookName
            int bid = 0;
            String bid1;
            try {
                bid1 = deleteBook.getLabel1Field().getText();
                bid = Integer.parseInt(bid1);
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(deleteBook, "书号不能为空！", "警告", JOptionPane.INFORMATION_MESSAGE);
            }

            BookDaoImpl bookDao = new BookDaoImpl();
            int count =  bookDao.bookDelete(bid);
            if (count == 1) {
                int result = JOptionPane.showConfirmDialog(deleteBook, "确定要删除图书编号为：" + bid + "的图书吗？", "警告", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {// 通过 bookId 删除书籍信息
                    //deleteBookJDBC.deleteBookInfoByBookId(bid);
                    JOptionPane.showMessageDialog(deleteBook, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(deleteBook, "查无此书,删除失败！", "警告", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if ("返回".equals(text)) {
            try {
                new AdminFace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            deleteBook.dispose();
        }
    }
}
