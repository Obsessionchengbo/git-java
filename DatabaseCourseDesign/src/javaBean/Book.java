package javaBean;

public class Book {
    private int password;
    private String name;
    private String bookType;
    private int typeCount;
    private int bookNum;
    private String bookName;
    private int count;
    private String title;
    private int id;
    private String state;

    public Book() {
    }

    public Book(int password, String name, String bookType, int typeCount, int bookNum, String bookName, int count, String title, int id, String state) {
        this.password = password;
        this.name = name;
        this.bookType = bookType;
        this.typeCount = typeCount;
        this.bookNum = bookNum;
        this.bookName = bookName;
        this.count = count;
        this.title = title;
        this.id = id;
        this.state = state;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public int getTypeCount() {
        return typeCount;
    }

    public void setTypeCount(int typeCount) {
        this.typeCount = typeCount;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }

}
