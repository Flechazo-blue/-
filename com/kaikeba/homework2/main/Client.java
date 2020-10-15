package com.kaikeba.homework2.main;

import com.kaikeba.homework2.bean.Book;
import com.kaikeba.homework2.bean.User;
import com.kaikeba.homework2.dao.BooksDao;
import com.kaikeba.homework2.dao.UsersDao;
import com.kaikeba.homework2.view.View;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private Scanner input = new Scanner(System.in);
    private View v;
    private UsersDao usersDao;
    private BooksDao booksDao;

    public Client(View v, UsersDao usersDao, BooksDao booksDao) {
        this.v = v;
        this.usersDao = usersDao;
        this.booksDao = booksDao;
    }

    public Client() {
        this.v = new View();
        this.usersDao = new UsersDao();
        this.booksDao = new BooksDao();
    }

    public void signUp(){
        User user = v.signUp();
        if (usersDao.signUp(user)){
            v.success();
        }else{
            v.fail();
        }
    }

    public boolean signIn(){
        User user = v.signIn();
        if (usersDao.signIn(user)){
            v.success();
            return true;
        }else{
            v.fail();
            return false;
        }
    }

    public void manage(){
        String in = v.manage();
        switch(in){
            case "1":{
                add();
                break;
            } case "2":{
                update();
                break;
            } case "3":{
                delete();
                break;
            } case "4":{
                queryByFuzzyName();
                break;
            } case "5":{
                queryAll();
                break;
            } default:{
                v.fail();
                break;
            }
        }
    }

    private void add(){
        Book book = new Book();
        while(true){
            try{
                book = v.add();
                break;
            }catch(ParseException e){
                v.dateErro();
            }
        }
        if(booksDao.add(book)){
            v.success();
        }else{
            v.fail();
        }
    }

    private void update(){
        Book oldBook = new Book();
        Book newBook = new Book();
        oldBook = v.upDate();
        while(true){
            try{
                newBook = v.add();
                break;
            }catch(ParseException e){
                v.dateErro();
            }
        }
        if(booksDao.update(oldBook, newBook)){
            v.success();
        }else{
            v.fail();
        }
    }

    private void delete(){
        Book book = new Book();
        book = v.delete();
        if(booksDao.delete(book)){
            v.success();
        }else{
            v.fail();
        }
    }

    private void queryByFuzzyName(){
        String name = v.fuzzyQueryByName();
        ArrayList<Book> booklist = booksDao.queryByFuzzyName(name);
        for(Book book : booklist){
            System.out.println(book);
        }
        if(booklist.isEmpty()){
            v.noData();
        }
    }

    private void queryAll(){
        String in = v.queryMenu();
        ArrayList<Book> booklist;
        switch(in){
            case "1":{
                booklist = booksDao.queryByPriceAscending();
                v.showBooks(booklist);
                break;
            } case "2":{
                booklist = booksDao.queryByPriceDescending();
                v.showBooks(booklist);
                break;
            } case "3":{
                booklist = booksDao.queryByDateDescending();
                v.showBooks(booklist);
                break;
            } default:{
                v.fail();
                break;
            }
        }
    }

}
