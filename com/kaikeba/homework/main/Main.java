package com.kaikeba.homework.main;

import com.kaikeba.homework.dao.ExpressDao;
import com.kaikeba.homework.view.Views;

public class Main {

    public static void main(String[] args) {
        ExpressDao dao = new ExpressDao();
        Views v = new Views();

        v.welcome();
        m:while(true){
            int number = v.identityMenu();
            switch(number){
                case 0:{
                    v.bye();
                    break m;
                }
                case 1:{
                    new AdminClient(dao, v).client();
                    break;
                }
                case 2:{
                    new UserClient(dao, v).client();
                    break;
                }
            }
        }

    }

}
