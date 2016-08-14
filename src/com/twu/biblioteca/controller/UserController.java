package com.twu.biblioteca.controller;

import com.twu.biblioteca.dao.UserDao;
import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jlli on 8/6/16.
 */
public class UserController {
    private UserDao userDao = new UserDao();

    public boolean hasLoginUser() {
        return userDao.getLoginUser() != null;
    }

    public void showUserInfo() {
        User u = userDao.getLoginUser();
        Helper.printMsg(String.format("UserName:%-10s Email:%-20s PhoneNum:%-20s", u.getName(), u.getEmail(), u.getPhoneNum()));
    }

    public boolean Login(String username, String password) {
        User loginUser = userDao.findUserByName(username);
        if (loginUser != null) {
            if (userDao.isAuthUser(username, password)) {
                userDao.setUserStatusToLogin(loginUser);
                return true;
            }
        }
        return false;
    }

    public boolean Logout() {
        if(userDao.getLoginUser() != null) {
            userDao.setUserStatusToLogOut(userDao.getLoginUser());
            return true;
        }
        return false;
    }



}
