package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.UserController;
import com.twu.biblioteca.helper.Helper;

import java.io.IOException;

/**
 * Created by jlli on 8/6/16.
 */
public class LoginView {
    UserController user = new UserController();

    public void login() throws IOException {
        Helper.printMsg("Please input your username:");
        String username = Helper.getInputMsg(System.in);
        Helper.printMsg("Please input you password:");
        String password = Helper.getInputMsg(System.in);
        if (user.Login(username, password)) {
            Helper.printMsg("Login success, Now you can borrow book!");
        } else {
            if(user.findLoginUser())
                Helper.printMsg("You are alreadly Login!");
            else
                Helper.printMsg("Wrong username or password, please enter again");
        }
    }

    public void logout() {
        if(user.findLoginUser()) {
            user.getLoginUser().setStatus("LOGOUT");
            Helper.printMsg("Logout success. Thanks for using.");
        }else{
            Helper.printMsg("No User is Login. Please enter your option.");
        }
    }
}
