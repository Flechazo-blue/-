package com.kaikeba.homework.main;

import com.kaikeba.homework.bean.Express;
import com.kaikeba.homework.dao.ExpressDao;
import com.kaikeba.homework.view.Views;

public class AdminClient {
    private ExpressDao dao;
    private Views v;

    public AdminClient(ExpressDao dao, Views v) {
        this.dao = dao;
        this.v = v;
    }

    public AdminClient() {
    }

    public void client(){
        int chose = v.adminMenu();
        switch(chose){
            case 0: {
                break;
            }
            case 1: {
                Express e = v.add();
                boolean result = dao.add(e);
                if(result == false){
                    v.printExist();
                }else{
                    v.success();
                    v.printExpress(e);
                }
                break;
            }
            case 2: {
                Express e = v.delete();
                boolean result = dao.delete(e);
                if(result){
                    v.success();
                }else{
                    v.printNull();
                }
                break;
            }
            case 3: {
                Express e1 = v.update();
                if(dao.find(e1) == null){
                    v.printNull();
                    break;
                }
                Express e2 = v.add();
                if(dao.find(e2) != null){
                    v.printExist();
                    break;
                }
                dao.update(e1, e2);
                break;
            }
            case 4: {
                Express[][] e = dao.findAll();
                v.printAll(e);
                break;
            }
        }
    }
}
