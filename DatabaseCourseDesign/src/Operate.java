import javaBean.Book;

import java.util.Scanner;

public class Operate {
    Book book = new Book();
    Scanner sc = new Scanner(System.in);

    //界面 显示操作界面
    public void menu() throws Exception {
        boolean flag = true;
        while (flag) {
            System.out.println("请选择你的操作");
            System.out.println("1：注册");
            System.out.println("2: 登录");
            System.out.println("3: 管理员登录");
            System.out.println("4：退出");
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    register();
                    continue;
                case 2:
                    log();
                    continue;
                case 3:
                    admlog();
                    continue;
                case 4:
                    break;
            }
            flag = false;
        }
    }

    //注册功能 将数据存入数据库中
    public void register() throws Exception {
        System.out.print("请输入你是老师(输入职称)还是学生：");
        book.setTitle(sc.next());
        System.out.print("请输入你的名字: ");
        book.setName(sc.next());
        System.out.print("请输入你的学号或工号：");
        book.setId(sc.nextInt());
        System.out.print("请输入一个密码：");
        book.setPassword(sc.nextInt());
        boolean flag = dataBase.register(book.getId(), book.getPassword(), book.getTitle(), book.getName());
        System.out.println(flag);
    }

    //老师学生登录功能
    public void log() throws Exception {
        boolean b = true;
        System.out.println(" 0 ：老师，1 ：学生，请选择登录");
        int i = sc.nextInt();
        System.out.print("请输入你的账号: ");
        book.setId(sc.nextInt());
        System.out.print("请输入你的密码：");
        book.setPassword(sc.nextInt());
        while (b) {
            if (dataBase.log(book.getId(), book.getPassword(), i)) {
                System.out.println("1：借书");
                System.out.println("2：还书");
                System.out.println("3：查阅信息");
                System.out.println("4: 退出");
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        borrowbook();
                        continue;
                    case 2:
                        returnbook();
                        continue;
                    case 3:
                        view();
                        continue;
                    case 4:
                        b = false;
                        break;
                }
            } else
                System.out.println("账号或密码输入错误，请重新输入！");
            b = false;
        }
    }

    //管理员登录功能
    public void admlog() throws Exception {
        System.out.print("请输入你的账号: ");
        book.setId(sc.nextInt());
        System.out.print("请输入你的密码：");
        book.setPassword(sc.nextInt());
        boolean flag = true;
        while (flag) {
            if (dataBase.admLog(book.getId(), book.getPassword())) {
                System.out.println("");
                System.out.println("1：添加图书");
                System.out.println("2: 更改图书");
                System.out.println("3: 删除图书");
                System.out.println("4：查看图书信息");
                System.out.println("5: 退出");
                System.out.println("请输入您的操作：");
                int i = sc.nextInt();
                switch (i) {
                    case 1:
                        admadd();
                        continue;
                    case 2:
                        changeBook();
                        continue;
                    case 3:
                        delBook();
                        continue;
                    case 4:
                        view();
                        continue;
                    case 5:
                        flag = false;
                        break;
                }
            } else
                System.out.println("账号或密码输入错误，请重新输入！");
            flag = false;
        }

    }

    //管理员添加图书功能
    public void admadd() throws Exception {
        System.out.println("请输入图书信息");
        System.out.print("请输入图书编号：");
        book.setBookNum(sc.nextInt());
        System.out.print("请输入图书名：");
        book.setBookName(sc.next());
        System.out.print("请输入图书存量：");
        book.setCount(sc.nextInt());
        System.out.print("请输入图书类型：");
        book.setBookType(sc.next());
        dataBase.add(book.getBookNum(), book.getBookName(), book.getCount(), book.getBookType());
    }

    //借书功能
    public void borrowbook() throws Exception {
        System.out.print("请输入你要借的书名: ");
        book.setBookName(sc.next());
        dataBase.borrowBook(book.getId(), book.getBookName());
    }

    //还书功能
    public void returnbook() throws Exception {
        System.out.print("请输入你要还的书名: ");
        book.setBookName(sc.next());
        dataBase.returnBook(book.getId(), book.getBookName());
    }

    //查阅信息功能
    public void view() throws Exception {
        dataBase.view();
    }

    //管理员更改图书信息功能
    public void changeBook() throws Exception {
        System.out.println("请输入需要更改的图书名或图书编号");
        //book.setBookname(sc.next());
        book.setBookNum(sc.nextInt());
        dataBase.change(book.getBookNum());
    }

    //删除图书信息功能
    public void delBook() throws Exception {
        System.out.println("请输入需要删除的图书名或图书编号");
        //book.setBookname(sc.next());
        book.setBookNum(sc.nextInt());
        dataBase.delete(book.getBookNum());
    }
}
