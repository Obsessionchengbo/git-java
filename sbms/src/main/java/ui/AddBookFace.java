package ui;

import javax.swing.*;
import java.awt.*;

public class AddBookFace extends JFrame {
    SpringLayout springLayout = new SpringLayout();//弹簧布局
    JPanel jPanel = new JPanel(springLayout);
    JLabel head = new JLabel("添加书籍");
    JLabel label1 = new JLabel("书号：");
    JTextField label1Field = new JTextField();
    JLabel label2 = new JLabel("书名：");
    JTextField label2Field = new JTextField();
    JLabel label3 = new JLabel("作者：");
    JTextField label3Field = new JTextField();
    JLabel label4 = new JLabel("出版社：");
    JTextField label4Field = new JTextField();
    JLabel label5 = new JLabel("简介：");
    JTextField label5Field = new JTextField();
    JLabel label6 = new JLabel("书籍类型：");
    JTextField label6Field = new JTextField();
    JLabel label7 = new JLabel("书籍定价：");
    JTextField label7Field = new JTextField();
    JLabel label8 = new JLabel("书籍数量：");
    JTextField label8Field = new JTextField();
    JButton JB1 = new JButton("添加");
    JButton JB2 = new JButton("返回");
    AddBook loginHandler5;

    public AddBookFace() {
        super("添加书籍");

        loginHandler5 = new AddBook(this);
        Container contentPane = getContentPane();

        head.setFont(new Font("华文行楷", Font.BOLD, 40));
        jPanel.add(head);
        jPanel.add(label1);
        label1Field.setPreferredSize(new Dimension(200, 30));
        jPanel.add(label1Field);
        jPanel.add(label2);
        label2Field.setPreferredSize(new Dimension(200, 30));
        jPanel.add(label2Field);
        jPanel.add(label3);
        label3Field.setPreferredSize(new Dimension(200, 30));
        jPanel.add(label3Field);
        jPanel.add(label4);
        label4Field.setPreferredSize(new Dimension(200, 30));
        jPanel.add(label4Field);
        jPanel.add(label5);
        label5Field.setPreferredSize(new Dimension(200, 30));
        jPanel.add(label5Field);
        jPanel.add(label6);
        label6Field.setPreferredSize(new Dimension(200, 30));
        jPanel.add(label6Field);
        jPanel.add(label7);
        label7Field.setPreferredSize(new Dimension(200, 30));
        jPanel.add(label7Field);
        jPanel.add(label8);
        label8Field.setPreferredSize(new Dimension(200, 30));
        jPanel.add(label8Field);
        JB1.addActionListener(loginHandler5);
        jPanel.add(JB1);
        JB2.addActionListener(loginHandler5);
        jPanel.add(JB2);
        //布局
        layoutCenter();

        contentPane.add(jPanel);

        //设置默认按钮
        getRootPane().setDefaultButton(JB1);
        setSize(600, 750);//单位：像素
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
        Spring childWidth = Spring.sum(headWidth, spaceWidth);
        int offsetX = childWidth.getValue() / 2;

        SpringLayout.Constraints headC = springLayout.getConstraints(head);
        springLayout.putConstraint(SpringLayout.WEST, head, -offsetX, SpringLayout.HORIZONTAL_CENTER, jPanel);
        headC.setY(Spring.constant(50));
        //设置label1,西边与head西边对齐，北边和head的南边距离20px
        springLayout.putConstraint(SpringLayout.WEST, label1, 0, SpringLayout.WEST, head);
        springLayout.putConstraint(SpringLayout.NORTH, label1, 20, SpringLayout.SOUTH, head);
        //设置label1Field,北边和label1的北边对齐，西边和label1的东边距离20px
        springLayout.putConstraint(SpringLayout.NORTH, label1Field, 0, SpringLayout.NORTH, label1);
        springLayout.putConstraint(SpringLayout.WEST, label1Field, 20, SpringLayout.EAST, label1);
        //设置label2,西边与label1西边对齐，北边和label1的南边距离50px
        springLayout.putConstraint(SpringLayout.EAST, label2, 0, SpringLayout.EAST, label1);
        springLayout.putConstraint(SpringLayout.NORTH, label2, 50, SpringLayout.SOUTH, label1);
        //设置label2Field，北边和label2的北边对齐，西边和label2的东边距离20px
        springLayout.putConstraint(SpringLayout.NORTH, label2Field, 0, SpringLayout.NORTH, label2);
        springLayout.putConstraint(SpringLayout.WEST, label2Field, 20, SpringLayout.EAST, label2);
        //设置label3,西边与label2西边对齐，北边和label2的南边距离50px
        springLayout.putConstraint(SpringLayout.EAST, label3, 0, SpringLayout.EAST, label2);
        springLayout.putConstraint(SpringLayout.NORTH, label3, 50, SpringLayout.SOUTH, label2);
        //设置label3Field，北边和label3的北边对齐，西边和label3的东边距离20px
        springLayout.putConstraint(SpringLayout.NORTH, label3Field, 0, SpringLayout.NORTH, label3);
        springLayout.putConstraint(SpringLayout.WEST, label3Field, 20, SpringLayout.EAST, label3);
        //设置label4,西边与label3西边对齐，北边和label3的南边距离50px
        springLayout.putConstraint(SpringLayout.EAST, label4, 0, SpringLayout.EAST, label3);
        springLayout.putConstraint(SpringLayout.NORTH, label4, 50, SpringLayout.SOUTH, label3);
        //设置label4Field，北边和label4的北边对齐，西边和label4的东边距离20px
        springLayout.putConstraint(SpringLayout.NORTH, label4Field, 0, SpringLayout.NORTH, label4);
        springLayout.putConstraint(SpringLayout.WEST, label4Field, 20, SpringLayout.EAST, label4);
        //设置label5,西边与label4西边对齐，北边和label4的南边距离50px
        springLayout.putConstraint(SpringLayout.EAST, label5, 0, SpringLayout.EAST, label4);
        springLayout.putConstraint(SpringLayout.NORTH, label5, 50, SpringLayout.SOUTH, label4);
        //设置label5Field，北边和label5的北边对齐，西边和label5的东边距离20px
        springLayout.putConstraint(SpringLayout.NORTH, label5Field, 0, SpringLayout.NORTH, label5);
        springLayout.putConstraint(SpringLayout.WEST, label5Field, 20, SpringLayout.EAST, label5);
        //设置label6,西边与label5西边对齐，北边和label5的南边距离50px
        springLayout.putConstraint(SpringLayout.EAST, label6, 0, SpringLayout.EAST, label5);
        springLayout.putConstraint(SpringLayout.NORTH, label6, 50, SpringLayout.SOUTH, label5);
        //设置label6Field，北边和label6的北边对齐，西边和label6的东边距离20px
        springLayout.putConstraint(SpringLayout.NORTH, label6Field, 0, SpringLayout.NORTH, label6);
        springLayout.putConstraint(SpringLayout.WEST, label6Field, 20, SpringLayout.EAST, label6);
        //设置label7,西边与label6西边对齐，北边和label6的南边距离50px
        springLayout.putConstraint(SpringLayout.EAST, label7, 0, SpringLayout.EAST, label6);
        springLayout.putConstraint(SpringLayout.NORTH, label7, 50, SpringLayout.SOUTH, label6);
        //设置label7Field，北边和label7的北边对齐，西边和label7的东边距离20px
        springLayout.putConstraint(SpringLayout.NORTH, label7Field, 0, SpringLayout.NORTH, label7);
        springLayout.putConstraint(SpringLayout.WEST, label7Field, 20, SpringLayout.EAST, label7);
        //设置label8,西边与label7西边对齐，北边和label7的南边距离50px
        springLayout.putConstraint(SpringLayout.EAST, label8, 0, SpringLayout.EAST, label7);
        springLayout.putConstraint(SpringLayout.NORTH, label8, 50, SpringLayout.SOUTH, label7);
        //设置label8Field，北边和label8的北边对齐，西边和label8的东边距离20px
        springLayout.putConstraint(SpringLayout.NORTH, label8Field, 0, SpringLayout.NORTH, label8);
        springLayout.putConstraint(SpringLayout.WEST, label8Field, 20, SpringLayout.EAST, label8);
        //设置JB1，西边与label8西边对齐，北边和label8的南边距离50px
        springLayout.putConstraint(SpringLayout.EAST, JB1, 0, SpringLayout.EAST, label8);
        springLayout.putConstraint(SpringLayout.NORTH, JB1, 50, SpringLayout.SOUTH, label8);
        //设置JB2，北边与JB1北边对齐，西边和JB1的东边距离50px
        springLayout.putConstraint(SpringLayout.NORTH, JB2, 0, SpringLayout.NORTH, JB1);
        springLayout.putConstraint(SpringLayout.WEST, JB2, 50, SpringLayout.EAST, JB1);
    }

    public static void main(String[] args) {
        new AddBookFace();
    }

    public JTextField getLabel1Field() {
        return label1Field;
    }

    public JTextField getLabel2Field() {
        return label2Field;
    }

    public JTextField getLabel3Field() {
        return label3Field;
    }

    public JTextField getLabel4Field() {
        return label4Field;
    }

    public JTextField getLabel5Field() {
        return label5Field;
    }

    public JTextField getLabel6Field() {
        return label6Field;
    }

    public JTextField getLabel7Field() {
        return label7Field;
    }

    public JTextField getLabel8Field() {
        return label8Field;
    }
}
