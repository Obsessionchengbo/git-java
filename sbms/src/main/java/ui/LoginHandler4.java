package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHandler4 implements ActionListener {

    private User user;
    public LoginHandler4(User user){
        this.user = user;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if("借阅书籍".equals(text)){

        } else if ("归还书籍".equals(text)) {

        } else if ("查看书籍".equals(text)) {

        } else if ("支付罚款".equals(text)) {

        } else if("退出系统".equals(text)){
            int result = JOptionPane.showConfirmDialog(user, "点击“确定”按钮，将退出注册界面并返回到登录界面!\n确定继续吗？", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                try {
                    new MainFace();
                    user.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
