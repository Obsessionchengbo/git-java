package ui;

import daoImpl.UserDaoImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class LoginHandler extends KeyAdapter implements ActionListener {

    private MainFace loginFace;


    public LoginHandler(MainFace loginFace) {
        this.loginFace = loginFace;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("登录".equals(text)) {
            login();
        } else if ("注册".equals(text)) {
            try {
                new RegisterFace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            loginFace.dispose();
        } else if ("重置".equals(text)) {
            loginFace.getLabel1Field().setText("");
            loginFace.getLabel2Field().setText("");
        }
    }


    private void login() {
        String userid = loginFace.getLabel1Field().getText();
        String chars = loginFace.getLabel2Field().getText();
        boolean a = loginFace.radioButton1.isSelected();
        System.out.println(userid + ":" + chars + a);

        //查询

        UserDaoImpl userDao = new UserDaoImpl();
        ArrayList<bean.User> list = userDao.userSelect();
        bean.User user = new bean.User();
        boolean flag = false;
        int i = 0;
        while (i < list.size()) {
            user = list.get(i);
            if (userid.equals(user.getUserName())) {
                if (chars.equals(user.getPassword())) {
                    flag = true;
                    break;
                }
            }
            i++;
        }


        if (!a) {
            if (userid.equals("admin") && chars.equals("123456")) {
                try {
                    new AdminFace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                loginFace.dispose();
            } else {
                JOptionPane.showMessageDialog(loginFace, "用户名或者密码错误");
            }
        } else {
            if (flag) {
                try {
                    new UserFace(userid);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                loginFace.dispose();
            } else {
                JOptionPane.showMessageDialog(loginFace, "用户名或者密码错误");
            }
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ENTER == e.getKeyCode()) {
            login();
        }
    }
}
