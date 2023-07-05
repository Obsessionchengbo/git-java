package ui;

import javax.swing.*;
import java.awt.*;

public class User extends JFrame{
    SpringLayout springLayout = new SpringLayout();//弹簧布局
    JPanel jPanel = new JPanel(springLayout);
    JLabel head = new JLabel("用户界面");
    JButton JB1 = new JButton("借阅书籍");
    JButton JB2 = new JButton("归还书籍");
    JButton JB3 = new JButton("查看书籍");
    JButton JB4 = new JButton("支付罚款");
    JButton JB5 = new JButton("退出系统");
    LoginHandler4 loginHandler4;
    public User() {
        super("用户界面");

        loginHandler4 = new LoginHandler4(this);
        Container contentPane = getContentPane();

        head.setFont(new Font("华文行楷",Font.BOLD,40));
        jPanel.add(head);
        JB1.addActionListener(loginHandler4);
        jPanel.add(JB1);
        JB2.addActionListener(loginHandler4);
        jPanel.add(JB2);
        JB3.addActionListener(loginHandler4);
        jPanel.add(JB3);
        JB4.addActionListener(loginHandler4);
        jPanel.add(JB4);
        JB5.addActionListener(loginHandler4);
        jPanel.add(JB5);
        //布局
        layoutCenter();

        contentPane.add(jPanel);

        // 设置窗口属性
        setSize(600, 400);//单位：像素
        //居中
        setLocationRelativeTo(null);
        //关闭退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //大小不可改变
        setResizable(false);
        setVisible(true);

    }

    private void layoutCenter() {
        Spring headWidth = Spring.width(head);
        Spring spaceWidth = Spring.constant(20);
        Spring childWidth = Spring.sum(headWidth,spaceWidth);
        int offsetX = childWidth.getValue() / 2;

        SpringLayout.Constraints headC = springLayout.getConstraints(head);
        springLayout.putConstraint(SpringLayout.WEST,head,-offsetX,SpringLayout.HORIZONTAL_CENTER,jPanel);
        //JB2
        springLayout.putConstraint(SpringLayout.WEST,JB2,0,SpringLayout.WEST,head);
        springLayout.putConstraint(SpringLayout.NORTH,JB2,50,SpringLayout.SOUTH,head);
        //JB1
        springLayout.putConstraint(SpringLayout.EAST,JB1,-50,SpringLayout.WEST,JB2);
        springLayout.putConstraint(SpringLayout.NORTH,JB1,0,SpringLayout.NORTH,JB2);
        //JB3
        springLayout.putConstraint(SpringLayout.WEST,JB3,50,SpringLayout.EAST,JB2);
        springLayout.putConstraint(SpringLayout.NORTH,JB3,0,SpringLayout.NORTH,JB2);
        //JB5
        springLayout.putConstraint(SpringLayout.WEST,JB5,0,SpringLayout.WEST,JB2);
        springLayout.putConstraint(SpringLayout.NORTH,JB5,50,SpringLayout.SOUTH,JB2);
        //JB4
        springLayout.putConstraint(SpringLayout.EAST,JB4,-50,SpringLayout.WEST,JB5);
        springLayout.putConstraint(SpringLayout.NORTH,JB4,0,SpringLayout.NORTH,JB5);
    }
    public static void main(String[] args) {
        new User();
    }
}
