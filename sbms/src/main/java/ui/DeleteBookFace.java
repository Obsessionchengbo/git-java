package ui;//LoginHandler6

import javax.swing.*;
import java.awt.*;

public class DeleteBookFace extends JFrame {
    SpringLayout springLayout = new SpringLayout();//弹簧布局
    JPanel jPanel = new JPanel(springLayout);
    JLabel head = new JLabel("删除书籍");
    JLabel label1 = new JLabel("书名：");
    JTextField label1Field = new JTextField();
    JButton JB1 = new JButton("删除");
    JButton JB2 = new JButton("返回");
    LoginHandler6 loginHandler6;

    public DeleteBookFace() {
        super("删除界面");

        loginHandler6 = new LoginHandler6(this);
        Container contentPane = getContentPane();

        head.setFont(new Font("华文行楷", Font.BOLD, 40));
        jPanel.add(head);
        jPanel.add(label1);
        label1Field.setPreferredSize(new Dimension(200, 30));
        jPanel.add(label1Field);
        JB1.addActionListener(loginHandler6);
        jPanel.add(JB1);
        JB2.addActionListener(loginHandler6);
        jPanel.add(JB2);
        //布局
        layoutCenter();

        contentPane.add(jPanel);

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
        Spring childWidth = Spring.sum(headWidth, spaceWidth);
        int offsetX = childWidth.getValue() / 2;

        SpringLayout.Constraints headC = springLayout.getConstraints(head);
        springLayout.putConstraint(SpringLayout.WEST, head, -offsetX, SpringLayout.HORIZONTAL_CENTER, jPanel);
        //label1
        springLayout.putConstraint(SpringLayout.WEST, label1, 0, SpringLayout.WEST, head);
        springLayout.putConstraint(SpringLayout.NORTH, label1, 50, SpringLayout.SOUTH, head);
        //label1Field
        springLayout.putConstraint(SpringLayout.WEST, label1Field, 20, SpringLayout.EAST, label1);
        springLayout.putConstraint(SpringLayout.NORTH, label1Field, 0, SpringLayout.NORTH, label1);
        //JB1
        springLayout.putConstraint(SpringLayout.WEST, JB1, 0, SpringLayout.WEST, label1);
        springLayout.putConstraint(SpringLayout.NORTH, JB1, 50, SpringLayout.SOUTH, label1);
        //JB2
        springLayout.putConstraint(SpringLayout.NORTH, JB2, 0, SpringLayout.NORTH, JB1);
        springLayout.putConstraint(SpringLayout.WEST, JB2, 50, SpringLayout.EAST, JB1);
    }

    public static void main(String[] args) {
        new DeleteBookFace();
    }

    public JTextField getLabel1Field() {
        return label1Field;
    }
}
