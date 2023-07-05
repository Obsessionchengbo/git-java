package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHandler3 implements ActionListener {

    private AdminFace librarian;

    public LoginHandler3(AdminFace librarian) {
        this.librarian = librarian;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("增加书籍".equals(text)) {
            try {
                new AddBookFace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            librarian.dispose();
        } else if ("删除书籍".equals(text)) {
            try {
                new DeleteBookFace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            librarian.dispose();
        } else if ("更改书籍".equals(text)) {

        } else if ("查看书籍".equals(text)) {
            try {
                new LookBookFace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            librarian.dispose();
        } else if ("增加用户".equals(text)) {

        } else if ("删除用户".equals(text)) {

        } else if ("更改用户".equals(text)) {

        } else if ("查看用户".equals(text)) {

        } else if ("退出系统".equals(text)) {
            int result = JOptionPane.showConfirmDialog(librarian, "点击“确定”按钮，将退出注册界面并返回到登录界面!\n确定继续吗？", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                try {
                    new MainFace();
                    librarian.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
