package com.twu.biblioteca.controller;

import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jlli on 8/6/16.
 */
public class UserController {
    private static List<User> users;
    public List<User> getAllUsers() {
        if(users == null) {
            users = Helper.intializeUsers();
        }
        return users;
    }

    public boolean isLogin(String username){
        return getAllUsers().stream().anyMatch(i -> i.getName().equals(username) && i.getStatus() == "LOGIN");
    }

    public User getLoginUser() {
        return getAllUsers().stream().filter(u -> u.getStatus().equals("LOGIN")).findFirst().orElse(null);
    }

    public boolean findLoginUser() {
        return getAllUsers().stream().anyMatch(u -> u.getStatus() == "LOGIN");
    }

    public List<Book> getUserBooks(){
        if(findLoginUser()){
            return getLoginUser().getBookList();
        }else return new ArrayList<>();
    }

    public void setUsersBooks(List<Book> bookList){
        if(findLoginUser()) {
            getLoginUser().setBookList(bookList);
        }
    }

    public User findUserByName(String username) {
        return getAllUsers().stream().filter(u -> u.getName().equals(username)).findFirst().orElse(null);
    }

    public boolean Login(String username, String password) {
        if (!findLoginUser()) {
            boolean auth = getAllUsers().stream().anyMatch(i -> i.getName().equals(username) && i.getPassword().equals(password));
            if (auth) {
                findUserByName(username).setStatus("LOGIN");
                return true;
            }
        }
        return false;
    }
}
