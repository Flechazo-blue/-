package com.kaikeba.homework2.view;

import com.kaikeba.homework2.bean.Book;
import com.kaikeba.homework2.bean.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class View {
    private Scanner input = new Scanner(System.in);

    public void welcome(){
        System.out.println("欢迎使用图书管理系统。");
    }

    public void bye(){
        System.out.println("欢迎下次使用。");
    }

    public String menu(){
        System.out.println("请输入操作编号来进行操作。");
        System.out.println("1.注册");
        System.out.println("2.登录");
        System.out.println("3.图书管理");
        System.out.println("4.退出");
        return input.nextLine();
    }

    public User signUp(){
        User user = new User();
        String userPass, userName;
        while(true){
            System.out.println("开始注册。");
            System.out.println("请输入用户名：");
            userName = input.nextLine();
            System.out.println("请输入密码：");
            userPass = input.nextLine();
            System.out.println("请重新输入密码：");
            String userPass2 = input.nextLine();
            if(userPass.equals(userPass2)){
                break;
            }else{
                System.out.println("密码不一致，请重新输入！");
            }
        }
        user.setUserName(userName);
        user.setUserPass(userPass);
        return user;
    }

    public User signIn(){
        User user = new User();
        System.out.println("开始登录。");
        System.out.println("请输入用户名：");
        String userName = input.nextLine();
        System.out.println("请输入密码：");
        String userPass = input.nextLine();
        user.setUserName(userName);
        user.setUserPass(userPass);
        return user;
    }

    public String manage(){
        System.out.println("请输入操作编号来进行操作。");
        System.out.println("1.图书新增");
        System.out.println("2.图书修改");
        System.out.println("3.图书删除");
        System.out.println("4.根据图书名称模糊查询图书");
        System.out.println("5.查看所有图书");
        return input.nextLine();
    }

    public Book add() throws ParseException {
        Book book = new Book();
        String inStr;
        Date inDate;
        Double inDouble;
        System.out.println("请输入新增图书的ISBN码：");
        inStr = input.nextLine();
        book.setISBN(inStr);
        System.out.println("请输入图书名：");
        inStr = input.nextLine();
        book.setName(inStr);
        System.out.println("请输入图书出版日期：（格式：yyyy-MM-dd）");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        inStr = input.nextLine();
        inDate = format.parse(inStr);
        book.setPublishDate(inDate);
        System.out.println("请输入图书价格：");
        inStr = input.nextLine();
        inDouble = Double.valueOf(inStr);
        book.setPrice(inDouble);
        return book;
    }

    public Book upDate() {
        Book book = new Book();
        String inStr;
        System.out.println("请输入需要更改的图书的ISBN码：");
        inStr = input.nextLine();
        book.setISBN(inStr);
        return book;
    }

    public Book delete(){
        Book book = new Book();
        String inStr;
        System.out.println("请输入需要删除的图书的ISBN码：");
        inStr = input.nextLine();
        book.setISBN(inStr);
        return book;
    }

    public String fuzzyQueryByName(){
        Book book = new Book();
        String inStr;
        System.out.println("请输入图书名：");
        inStr = input.nextLine();
        return inStr;
    }

    public String queryMenu(){
        System.out.println("请输入排列方式：");
        System.out.println("1.价格升序");
        System.out.println("2.价格降序");
        System.out.println("3.出版日期升序");
        return input.nextLine();
    }

    public void showBooks(ArrayList<Book> books){
        for(Book book : books){
            System.out.println(book);
        }
    }

    public void success(){
        System.out.println("操作成功！");
    }

    public void fail(){
        System.out.println("操作失败。");
    }

    public void dateErro(){
        System.out.println("请输入正确的日期格式。");
    }

    public void noData(){
        System.out.println("暂无数据。");
    }

    public void pleaseSignInFirst(){
        System.out.println("请先登录，进行操作。");
    }
}
