package ui;//LoginHandler8

import dao.BookDao;
import daoImpl.BookDaoImpl;

import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookBookFace extends JFrame implements ActionListener {

    public LookBookFace() throws Exception {
        initJFrame();
        initTable();
    }

    private void initTable() throws Exception {
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.bookSelectAll();
        Vector<Vector<Object>> data = new Vector<>();
        //数据库调数据
        //DatabaseSystemLink.displayData(data);
        //JTable和tableModel关联后只需要更新tableModel即可更新数据变化反映到JTable
        ShowGoodsViewHeader showGoodsHeader = ShowGoodsViewHeader.assembleModel(data);

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
        Vector<String> columns = ShowGoodsViewHeader.getColumns();
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

    private void initJFrame() {
        this.setTitle("书籍列表主界面");

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
    }
}

class ShowGoodsViewHeader extends DefaultTableModel {
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

    private ShowGoodsViewHeader() {
        super(null, columns);
    }

    private static ShowGoodsViewHeader studentTableModel1 = new ShowGoodsViewHeader();

    public static ShowGoodsViewHeader assembleModel(Vector<Vector<Object>> data) {
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
