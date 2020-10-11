package com.kaikeba.homework.main;

import com.kaikeba.homework.bean.Express;
import com.kaikeba.homework.dao.ExpressDao;
import com.kaikeba.homework.view.Views;

public class UserClient {
    private ExpressDao dao;
    private Views v;

    public UserClient(ExpressDao dao, Views v) {
        this.dao = dao;
        this.v = v;
    }

    public UserClient() {
    }

    public void client(){
        int code = v.userMenu();
        Express e = dao.findByCode(code);
        if(e == null){
            v.printNull();
        }else{
            dao.delete(e);
            v.printExpress(e);
            v.success();
        }
    }
}
