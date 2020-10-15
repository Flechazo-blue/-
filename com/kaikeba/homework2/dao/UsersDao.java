package com.kaikeba.homework2.dao;

import com.kaikeba.homework2.bean.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UsersDao {
    Map<String, String> usersMap = new HashMap<>();

    public boolean add(User user){
        if(usersMap.put(user.getUserName(), user.getUserPass()) == null){
            return true;
        }
        return false;
    }

    public boolean signUp(User user){
        if(usersMap.containsKey(user.getUserName())){
            return false;
        }
        usersMap.put(user.getUserName(), user.getUserPass());
        return true;
    }

    public boolean signIn(User user){
        if(Objects.equals(usersMap.get(user.getUserName()), user.getUserPass())){
            return true;
        }else{
            return false;
        }
    }
}
