package ui;

import javax.swing.*;
import java.awt.*;

//主界面
@SuppressWarnings("all")
public class MainFace extends JFrame {
    SpringLayout springLayout = new SpringLayout();//弹簧布局
    JPanel jPanel = new JPanel(springLayout);
    JLabel head = new JLabel("学校图书管理系统");
    JLabel label1 = new JLabel("账号：");
    JTextField label1Field = new JTextField();
    JLabel label2 = new JLabel("密码：");
    JTextField label2Field = new JTextField();
    JButton JB1 = new JButton("登录");
    JButton JB2 = new JButton("注册");
    JButton JB3 = new JButton("重置");
    JRadioButton radioButton1 = new JRadioButton("用户", true);
    JRadioButton radioButton2 = new JRadioButton("管理员", false);
    LoginHandler loginHandler;

    public MainFace() {
        super("学校图书管理系统");

        loginHandler = new LoginHandler(this);
        Container contentPane = getContentPane();

        head.setFont(new Font("华文行楷", Font.BOLD, 40));
        jPanel.add(head);
        jPanel.add(radioButton1);
        jPanel.add(radioButton2);
        jPanel.add(label1);
        label1Field.setPreferredSize(new Dimension(200, 30));
        jPanel.add(label1Field);
        jPanel.add(label2);
        label2Field.setPreferredSize(new Dimension(200, 30));
        jPanel.add(label2Field);
        JB1.addActionListener(loginHandler);
        JB1.addKeyListener(loginHandler);//增加按键事件
        jPanel.add(JB1);
        JB2.addActionListener(loginHandler);
        jPanel.add(JB2);
        JB3.addActionListener(loginHandler);
        jPanel.add(JB3);
        ButtonGroup gGroup = new ButtonGroup();
        gGroup.add(radioButton1);
        gGroup.add(radioButton2);
        //布局
        layoutCenter();

        contentPane.add(jPanel);

        //设置默认按钮
        getRootPane().setDefaultButton(JB1);
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
        //布局
        Spring headWidth = Spring.width(head);
        Spring spaceWidth = Spring.constant(20);
        Spring childWidth = Spring.sum(headWidth, spaceWidth);
        int offsetX = childWidth.getValue() / 2;

        SpringLayout.Constraints headC = springLayout.getConstraints(head);
        springLayout.putConstraint(SpringLayout.WEST, head, -offsetX, SpringLayout.HORIZONTAL_CENTER, jPanel);
        headC.setY(Spring.constant(50));
        //设置按钮radioButton1,北边距离head南边20px，西边和head的西边对齐
        springLayout.putConstraint(SpringLayout.NORTH, radioButton1, 20, SpringLayout.SOUTH, head);
        springLayout.putConstraint(SpringLayout.WEST, radioButton1, 0, SpringLayout.WEST, head);
        //设置按钮radioButton2,北边与radioButton1北边对齐，西边和radioButton1的东边距离50px
        springLayout.putConstraint(SpringLayout.NORTH, radioButton2, 0, SpringLayout.NORTH, radioButton1);
        springLayout.putConstraint(SpringLayout.WEST, radioButton2, 50, SpringLayout.EAST, radioButton1);
        //设置账号label1，北边与radioButton2南边20px,西边与radioButton1西边对齐
        springLayout.putConstraint(SpringLayout.NORTH, label1, 20, SpringLayout.SOUTH, radioButton2);
        springLayout.putConstraint(SpringLayout.WEST, label1, 0, SpringLayout.WEST, radioButton1);
        //设置输入框label1Field,西边距离label1东边10px，北边和label1的北边对齐
        springLayout.putConstraint(SpringLayout.WEST, label1Field, 10, SpringLayout.EAST, label1);
        springLayout.putConstraint(SpringLayout.NORTH, label1Field, 0, SpringLayout.NORTH, label1);
        //设置密码label2,东边和label1的东边对齐，北边距离label1南边50px
        springLayout.putConstraint(SpringLayout.EAST, label2, 0, SpringLayout.EAST, label1);
        springLayout.putConstraint(SpringLayout.NORTH, label2, 50, SpringLayout.NORTH, label1);
        //设置输入框label2Field,西边距离label2东边10px，北边和label2的北边对齐
        springLayout.putConstraint(SpringLayout.WEST, label2Field, 10, SpringLayout.EAST, label2);
        springLayout.putConstraint(SpringLayout.NORTH, label2Field, 0, SpringLayout.NORTH, label2);
        //设置按钮JB1,北边距离label2南边40px，西边和label2的西边对齐
        springLayout.putConstraint(SpringLayout.NORTH, JB1, 40, SpringLayout.SOUTH, label2);
        springLayout.putConstraint(SpringLayout.WEST, JB1, 0, SpringLayout.WEST, label2);
        //设置按钮JB2,北边与JB1北边对齐，西边和JB1的东边距离50px
        springLayout.putConstraint(SpringLayout.NORTH, JB2, 0, SpringLayout.NORTH, JB1);
        springLayout.putConstraint(SpringLayout.WEST, JB2, 50, SpringLayout.EAST, JB1);
        //设置按钮JB3,北边与JB2北边对齐，西边和JB2的东边距离50px
        springLayout.putConstraint(SpringLayout.NORTH, JB3, 0, SpringLayout.NORTH, JB2);
        springLayout.putConstraint(SpringLayout.WEST, JB3, 50, SpringLayout.EAST, JB2);
    }

    public static void main(String[] args) {
        new MainFace();
    }

    public JTextField getLabel1Field() {
        return label1Field;
    }

    public JTextField getLabel2Field() {
        return label2Field;
    }

    public JRadioButton getRadioButton1() {
        return radioButton1;
    }

    public JRadioButton getRadioButton2() {
        return radioButton2;
    }

}
