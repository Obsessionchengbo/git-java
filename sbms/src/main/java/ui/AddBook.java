package ui;

import bean.Book;
import daoImpl.BookDaoImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class AddBook extends KeyAdapter implements ActionListener {

    private AddBookFace addBook;

    public AddBook(AddBookFace addBook) {
        this.addBook = addBook;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("添加".equals(text)) {
            addBook();
        } else if ("返回".equals(text)) {
            try {
                addBook.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void addBook() {
        String bookName = addBook.getLabel2Field().getText();//书名
        String author = addBook.getLabel3Field().getText();//作者
        String press = addBook.getLabel4Field().getText();//出版社
        String synopsis = addBook.getLabel5Field().getText();//简介
        String bookType = addBook.getLabel6Field().getText();//类型

        int count = 0;
        String count1 = null;
        try {
            count = 0;
            count1 = null;
            count1 = addBook.getLabel8Field().getText();//数量
            count = Integer.parseInt(count1);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(addBook, "数量不能为空！", "警告", JOptionPane.ERROR_MESSAGE);
        }
        BookDaoImpl bookDao = new BookDaoImpl();
        ArrayList<Book> list = bookDao.bookSelectAll();
        Book book;

        boolean flag = true;
        int i = 0;
        while (i < list.size()) {
            book = list.get(i);
            if (bookName.equals(book.getBookName())) {//判断是否有相同的书
                flag = false;//相同为错
                break;
            }
            i++;
        }

        if (!flag) {
            book = list.get(i);
            Book book2 = new Book(book.getBid(), book.getBookName(), book.getAuthor(), book.getPress(), book.getSynopsis(), book.getBookType(), book.getPrice(), book.getCount() + count);
            bookDao.bookUpdate(book2);
            JOptionPane.showMessageDialog(addBook, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int bid = 0;
        float price = 0;
        String bid1 = null;
        String price1 = null;
        try {
            bid1 = addBook.getLabel1Field().getText();//书号
            bid = Integer.parseInt(bid1);
            price1 = addBook.getLabel7Field().getText();//定价
            price = Float.parseFloat(price1);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(addBook, "书号或定价不能为空", "警告", JOptionPane.ERROR_MESSAGE);
        }

        if (bid1.length() == 0 || bookName.length() == 0 || author.length() == 0 || press.length() == 0 ||
                synopsis.length() == 0 || bookType.length() == 0 || price1.length() == 0 || count1.length() == 0) {
            JOptionPane.showMessageDialog(addBook, "增加书籍的各项均不能为空！", "警告", JOptionPane.ERROR_MESSAGE);
        }
        if (flag) {
            if (bid1.length() != 0 && bookName.length() != 0 && author.length() != 0 && press.length() != 0 &&
                    synopsis.length() != 0 && bookType.length() != 0 && price1.length() != 0 && count1.length() != 0) {
                Book book1 = new Book(bid, bookName, author, press, synopsis, bookType, price, count);
                bookDao.bookInsert(book1);
                JOptionPane.showMessageDialog(addBook, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ENTER == e.getKeyCode()) {
            addBook();
        }
    }
}
