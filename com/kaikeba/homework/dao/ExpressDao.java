package com.kaikeba.homework.dao;

import com.kaikeba.homework.bean.Express;

import java.util.Random;

public class ExpressDao {
    private Express[][] data = new Express[10][10];
    private Random random = new Random();

    public boolean add(Express e){
        int code = -1;
        int x = -1;
        int y = -1;
        while(true){
            x = random.nextInt(10);
            y = random.nextInt(10);
            if(data[x][y] == null){
                break;
            }
        }
        while(true){
            code = random.nextInt(900000) + 100000;
            if(findByCode(code) == null){
                e.setCode(code);
                break;
            }
        }
        Express e2 = find(e);
        if(e2 != null){
            return false;
        }else{
            data[x][y] = e;
            return true;
        }
    }

    public Express findByNumber(String number){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(data[i][j] == null){
                    continue;
                }
                if(data[i][j].getNumber() == number){
                    return data[i][j];
                }
            }
        }
        return null;
    }

    public Express findByCode(int code){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(data[i][j] == null){
                    continue;
                }
                if(data[i][j].getCode() == code){
                    return data[i][j];
                }
            }
        }
        return null;
    }

    public Express find(Express e) {
        if(e == null){
            return null;
        }
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(e.equals(data[i][j])){
                    return data[i][j];
                }
            }
        }
        return null;
    }

    public boolean delete(Express e){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(e.equals(data[i][j])){
                    data[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean[] update(Express oldExpress, Express newExpress){
        boolean[] bool = new boolean[2];
        bool[0] = delete(oldExpress);
        bool[1] = add(newExpress);
        return bool;
    }

    public Express[][] findAll(){
        return data;
    }
}
