package com.chenze.DataStructure.link;

import java.util.Scanner;

/**
 * 本次的节点是书，节点包含了信息有：书的编号，名字，受欢迎的程度
 * 1.第一阶段实现单链表的基本操作
 * 2.第二阶段完善单链表的功能
 */
public class SingleLinkListDemo {
    static int bookNo;
    static String bookName;
    static Integer bookPopular;
    static SingleLinkList singleLinkList = new SingleLinkList();

   static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        boolean flag=true;
        while (flag) {
            cover();
            switch (in.next()) {
                case "add":
                    addBook();
                    break;
                case "delete":
                    deleteBook();
                    break;
                case "update":
                    updateBook();
                    break;
                case "list":
                    singleLinkList.list();
                    break;
                case "query":
                    queryBook();
                    break;
                case "exit":
                    flag=false;
                    break;
                default:
                    System.out.println("没该项功能~");
            }
        }
    }

    private static void cover() {
        System.out.println("*************单链表***************");
        System.out.println("        1.add");
        System.out.println("        2.delete");
        System.out.println("        3.update");
        System.out.println("        4.list");
        System.out.println("        5.query");
        System.out.println("        6.exit");
        System.out.println("*********************************");
        System.out.println("请输入选项:");
    }

    private static void queryBook() {
        System.out.println("请输入书的编号:");
         int no = in.nextInt();
         singleLinkList.query(no);
    }

    private static void updateBook() {
         BookNode newBookNode = new BookNode();
        System.out.println("请输入书的编号:");
         newBookNode.bookNo= in.nextInt();
        System.out.println("请输入书的名字:");
         newBookNode.bookName= in.next();
        System.out.println("请输入书的点赞率:");
         newBookNode.bookPopular=in.nextInt();
         if(newBookNode.bookName==null||newBookNode.bookPopular==null){
             System.out.println("不符合规则，不能进行修改");
             return;
         }
        singleLinkList.update(newBookNode);
    }

    private static void deleteBook() {
        System.out.println("请输入书的编号:");
         int no = in.nextInt();
         singleLinkList.delete(no);
    }

    private static void addBook() {
        BookNode bookNode = new BookNode();
        System.out.println("请输入书的编号:");
        bookNode.bookNo= in.nextInt();
        System.out.println("请输入书的名字:");
        bookNode.bookName= in.next();
        System.out.println("请输入书的点赞率:");
        bookNode.bookPopular=in.nextInt();
        if(bookNode.bookName==null||bookNode.bookPopular==null){
            System.out.println("不符合规则，不能进行添加");
            return;
        }
        singleLinkList.add(bookNode);
    }
}
//第一步生成BookNode节点
class BookNode{
    int bookNo;
    String bookName;
    Integer bookPopular;

    public BookNode nextBook;

    public BookNode(){

    }

    public BookNode(int bookNo, String bookName, Integer bookPopular) {
        this.bookNo = bookNo;
        this.bookName = bookName;
        this.bookPopular = bookPopular;
    }

    @Override
    public String toString() {
        return "BookNode{" +
                "bookNo=" + bookNo +
                ", bookName='" + bookName + '\'' +
                ", bookPopular=" + bookPopular +
                '}';
    }
}

//第二步定义一个管理类
class SingleLinkList{
    //先初始化一个头结点，该节点不含信息，该节点不能进行改变。
   private final BookNode head = new BookNode(0,"",null);
   //由于头结点不能改变，所以设置一个辅助变量进行代替头结点的功能
    BookNode temp =head;

   //返回头节点
    public BookNode getHead() {
        return head;
    }

    //添加节点
    public void add(BookNode bookNode){
        //运用尾插法
        while (temp.nextBook != null) {
            temp = temp.nextBook;
        }
            temp.nextBook=bookNode;
    }

    //修改节点信息
    public void update(BookNode newBookNode){
        //判断一下是否有节点
        if (head.nextBook==null){
            System.out.println("没有书了，无法进行更新");
            return;
        }
        //若通过，则表示至少有一个节点
        temp = head.nextBook;
        //需要设置一个标记
        boolean flag =false;//flag为false表示没有找到，true表示找到了
        while (temp != null) {
            if (temp.bookNo == newBookNode.bookNo) {
                flag = true;
                break;//表示找到了
            }
            temp=temp.nextBook;
        }
        //进行更新
        if (flag){
            temp.bookName=newBookNode.bookName;
            temp.bookPopular= newBookNode.bookPopular;
            System.out.println("更新完成了");
        }else {
            System.out.println("该书不存在，无法更新");
        }
    }

    //删除节点
    public void delete(int bookNo){
        //判断一下是否有节点
        if (head.nextBook==null){
            System.out.println("该书不存在，无法进行删除");
            return;
        }
        //若一个节点
        if (head.nextBook.nextBook==null){
            head.nextBook=null;
            return;
        }
        //若通过，则表示至少有两个节点
        temp = head.nextBook;
        //需要设置一个标记
        boolean flag =false;//flag为false表示没有找到，true表示找到了
        while (temp != null) {
            if (temp.nextBook.bookNo == bookNo) {
                flag = true;
                break;//表示找到了
            }
            temp=temp.nextBook;
        }
        //进行删除
        if (flag){
            temp.nextBook=temp.nextBook.nextBook;
            System.out.println("删除完成了");
        }else {
            System.out.println("该书不存在，无法删除");
        }
    }

    //遍历节点
    public void list(){
        //判断一下是否有节点
        if (head.nextBook==null){
            System.out.println("没有书了，无法进行遍历");
            return;
        }
        //若通过，则表示至少有一个节点
        temp = head.nextBook;
        while (true){
            if (temp==null){
                System.out.println("遍历完成~");
                break;
            }
            System.out.println(temp);
            temp=temp.nextBook;
        }
    }

    //查询节点
    public void query(int bookNo){
        //判断一下是否有节点
        if (head.nextBook==null){
            System.out.println("没有书了，无法进行删除");
            return;
        }
        //若通过，则表示至少有一个节点
        temp = head.nextBook;
        //需要设置一个标记
        boolean flag =false;//flag为false表示没有找到，true表示找到了
        while (temp != null) {
            if (temp.bookNo == bookNo) {
                flag = true;
                break;//表示找到了
            }
            temp=temp.nextBook;
        }
        //输出该节点
        if (flag){
            System.out.println("找到了~");
            System.out.println(temp);
        }else {
            System.out.println("没有找到~");
        }
    }
}