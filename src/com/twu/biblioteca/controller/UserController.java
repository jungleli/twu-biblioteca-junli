package com.twu.biblioteca.controller;

import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jlli on 8/6/16.
 */
public class UserController {
    public List<User> getAllUsers() {
        return Helper.intializeUsers();
    }

//    public boolean authenticate(String username, String password) {
//        return this.username.equals(username) && this.username.equals(password);
//    }
//    public boolean isLogin(String username){
//        return getAllUsers().stream().anyMatch(i -> i.getName() == username && i.getStatus() == 1);
//    }

    public boolean Login(String username, String password) {
        Helper.printMsg(username + password);

        return getAllUsers().stream().anyMatch(i -> i.getName() == username && i.getPassword() == password);
    }
}
