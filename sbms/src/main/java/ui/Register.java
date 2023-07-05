package ui;

import bean.User;
import daoImpl.UserDaoImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
@SuppressWarnings("all")
public class Register extends KeyAdapter implements ActionListener {

    private RegisterFace register;

    public Register(RegisterFace zhuCe) {
        this.register = zhuCe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("注册".equals(text)) {
            register();
        } else if ("返回".equals(text)) {
            try {
                new MainFace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            register.dispose();
        }
    }

    private void register() {
        String username = register.getLabel1Field().getText();//用户名
        String name = register.getLabel2Field().getText();//姓名
        //!!!!!!!!!!!!!!!!!!!!!!
        String position1 = null;
        int position = 0;//职称
        int age = 0;
        try {
            position1 = register.getLabel3Field().getText();
            position = Integer.parseInt(position1);
            String age1 = register.getLabel5Field().getText();
            age = Integer.parseInt(age1);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(register, "职称,年龄均不能为空！", "警告", JOptionPane.ERROR_MESSAGE);
        }
        String sex = register.getLabel4Field().getText();//性别
        //Integer age = register.getLabel5Field().getScrollOffset();//年龄
        String password = register.getLabel6Field().getText();//密码
        System.out.println(username);
        //查询
        //待修改----------------------!!!!!!!!!!!!!!!!

        boolean flag = true;
        UserDaoImpl userDao = new UserDaoImpl();
        ArrayList<User> list = userDao.userSelect();
        User user;
        int i = 0;
        while (i < list.size()) {
            user = list.get(i);
            if (username.equals(user.getUserName())) {
                flag = false;
                break;
            }
            i++;
        }

        if (flag) {
            if (username != null && name != null && position1 != null && password != null) {
                User u = list.get(list.size() - 1);
                int uid = u.getUid();
                // 调用插入方法
                //AddUserJDBC addUserJDBC = new AddUserJDBC();
                //addUserJDBC.addUserInfoToDatabase(username,username,position,sex,age,password);
                User user2 = new User(uid + 1, username, password, name, sex, age, position, 50F);
                userDao.userInsert(user2);

                JOptionPane.showMessageDialog(register, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            } else if (username == null || name == null || position1 == null || password == null) {//!!!!!!!!!!!!!!!!!!!!!!
                JOptionPane.showMessageDialog(register, "账号，姓名,职称和密码均不能为空！", "警告", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(register, "账号已被注册,请重新输入.");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ENTER == e.getKeyCode()) {
            register();
        }
    }
}
