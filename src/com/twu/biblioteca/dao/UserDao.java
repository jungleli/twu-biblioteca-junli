package com.twu.biblioteca.dao;

import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.User;

import java.util.List;

/**
 * Created by jlli on 8/14/16.
 */
public class UserDao {
    private static List<User> users;
    public List<User> getAllUsers() {
        if(users == null) {
            users = Helper.intializeUsers();
        }
        return users;
    }

    public User getLoginUser() {
        return getAllUsers().stream().filter(u -> u.getStatus().equals("LOGIN")).findFirst().orElse(null);
    }

    public User findUserByName(String username) {
        return getAllUsers().stream().filter(u -> u.getName().equals(username)).findFirst().orElse(null);
    }

    public boolean isAuthUser(String username, String password) {
        return getAllUsers().stream().anyMatch(i -> i.getName().equals(username) && i.getPassword().equals(password));
    }
    public void setUserStatusToLogin(User user) {
        user.setStatus("LOGIN");
    }

    public void setUserStatusToLogOut(User user) {
        user.setStatus("LOGOUT");
    }

}
