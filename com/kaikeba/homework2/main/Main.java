package com.kaikeba.homework2.main;

import com.kaikeba.homework2.dao.BooksDao;
import com.kaikeba.homework2.dao.UsersDao;
import com.kaikeba.homework2.view.View;

import java.util.Scanner;

public class Main {
    static public View v = new View();
    static public BooksDao booksDao = new BooksDao();
    static public UsersDao usersDao = new UsersDao();
    static public Scanner input = new Scanner(System.in);
    static public Client client = new Client(v, usersDao, booksDao);
    static public Boolean isSignIn = false;

    public static void main(String[] args){
        v.welcome();
        root1 : while(true){
            String in = v.menu();
            System.out.println(in);
            switch (in){
                case "1":{
                    client.signUp();
                    break;
                } case "2":{
                    if(client.signIn()){
                        isSignIn = true;
                    }else{
                        isSignIn = false;
                    }
                    break;
                } case "3":{
                    if(isSignIn){
                        client.manage();
                    }else{
                        v.pleaseSignInFirst();
                    }
                    break;
                }case "4": {
                    break root1;
                }default:{
                    v.fail();
                    break;
                }
            }
        }
        v.bye();
    }
}
