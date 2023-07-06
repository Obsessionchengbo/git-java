package ui;

import bean.Book;
import daoImpl.BookDaoImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

@SuppressWarnings("all")
public class BookSelectByOther extends JFrame implements ActionListener {
    JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JButton addBtn = new JButton("借阅书籍");
    JButton replenishBtn = new JButton("退还书籍");
    JButton JB1 = new JButton("借阅信息");
    JButton deleteBtn = new JButton("退出系统");
    JTextField searchTxt = new JTextField(15);
    JButton searchBtn = new JButton("查询");
    JButton renewBtn = new JButton("刷新");
    JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton preBtn = new JButton("上一页");
    JButton nextBtn = new JButton("下一页");
    private int pageNow = 1;//当前是第几页
    private int pageSize = 1;//一页显示多少条数据库记录

    public static String userName = "";
    public BookSelectByOther(String username,String bookname) throws Exception {
        userName = username;
        initJFrame(username);
        initTable(bookname);

    }

    private void initTable(String bookName) throws Exception {
        Vector<Vector<Object>> data = new Vector<>();
        BookDaoImpl bookDao = new BookDaoImpl();
        ArrayList<Book> list = bookDao.booksSelectByOther(bookName);
        Book book;

        for (int i = 0; i < list.size(); i++) {

            Vector<Object> v = new Vector<>();
            book = list.get(i);
            v.add(book.getBid());
            v.add(book.getBookName());
            v.add(book.getAuthor());
            v.add(book.getPress());
            v.add(book.getSynopsis());
            v.add(book.getBookType());
            v.add(book.getPrice());
            v.add(book.getCount());

            data.add(v);
        }

        ShowGoodsViewHeader6 showGoodsHeader = ShowGoodsViewHeader6.assembleModel(data);

        JTable jTable = new JTable(showGoodsHeader);
        //设置表头
        JTableHeader jTableHeader = new JTableHeader();
        jTableHeader.setFont(new Font(null, Font.BOLD, 16));
        jTableHeader.setForeground(Color.RED);
        //设值表格体
        jTable.setFont(new Font(null, Font.PLAIN, 14));
        jTable.setForeground(Color.BLACK);
        //表格线设置
        jTable.setGridColor(Color.BLACK);
        //表格行高
        jTable.setRowHeight(30);
        //设置多行选择(已经默认2）
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //列头没有了解决：
        JScrollPane jScrollPane = new JScrollPane(jTable);
        //设置表格列的渲染方式
        mainViewRenderRule(jTable);
        this.getContentPane().add(jScrollPane);
    }


    private static void mainViewRenderRule(JTable jTable) {
        Vector<String> columns = ShowGoodsViewHeader6.getColumns();
        for (int i = 0; i < columns.size(); i++) {
            TableColumn column = jTable.getColumn(columns.get(i));
            column.setCellRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    //隔行变色
                    if (row % 2 == 0) setBackground(Color.LIGHT_GRAY);
                    else setBackground(Color.WHITE);
                    //水平居中
                    setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            });
        }
    }


    private void initJFrame(String username) {
        this.setTitle("用户借阅列表主界面");

        northPanel.add(addBtn);
        northPanel.add(replenishBtn);
        northPanel.add(JB1);
        northPanel.add(deleteBtn);
        northPanel.add(searchTxt);
        northPanel.add(searchBtn);
        //
        northPanel.add(renewBtn);
        //

        this.getContentPane().add(northPanel, BorderLayout.NORTH);

        southPanel.add(preBtn);
        southPanel.add(nextBtn);
        getContentPane().add(southPanel, BorderLayout.SOUTH);

        //添加事件监听
        addBtn.addActionListener(this);
        replenishBtn.addActionListener(this);
        JB1.addActionListener(this);
        deleteBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        renewBtn.addActionListener(this);
        //根据屏幕大小设置主界面
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(new JFrame().getGraphicsConfiguration());
        setBounds(new Rectangle(screenInsets.left, screenInsets.top,
                screenSize.width - screenInsets.left - screenInsets.right,
                screenSize.height - screenInsets.top - screenInsets.bottom));
        //设置窗体充满整个屏幕
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = ((JButton) e.getSource()).getText();
        switch (name) {
            case "借阅书籍":
                new BorrowBook(userName);
                break;
            case "退还书籍":
                new ReturnBook(userName);
                break;
            case"借阅信息":
                try {
                    new BorrowInformationFace(userName);
                    this.dispose();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "退出系统":
                int result = JOptionPane.showConfirmDialog(this, "点击“确定”按钮，将退出注册界面并返回到登录界面!\n确定继续吗？", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    this.dispose();
                    try {
                        new MainFace();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                break;
            case "查询":
                String bookname1 = searchTxt.getText();
                this.dispose();
                try {
                    new BookSelectByOther(userName,bookname1);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "刷新":
                this.dispose();
                try {
                    new UserFace(userName);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                break;
            //
        }
    }
}

class ShowGoodsViewHeader6 extends DefaultTableModel {
    static Vector<String> columns = new Vector<>();

    static {
        columns.addElement("书号");
        columns.addElement("书名");
        columns.addElement("作者");
        columns.addElement("出版社");
        columns.addElement("简介");
        columns.addElement("类型");
        columns.addElement("定价");
        columns.addElement("数量");
    }

    private ShowGoodsViewHeader6() {
        super(null, columns);
    }

    private static ShowGoodsViewHeader6 studentTableModel1 = new ShowGoodsViewHeader6();

    public static ShowGoodsViewHeader6 assembleModel(Vector<Vector<Object>> data) {
        studentTableModel1.setDataVector(data, columns);
        return studentTableModel1;
    }

    public static Vector<String> getColumns() {
        return columns;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

