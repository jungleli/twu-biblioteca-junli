package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.UserController;
import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;

import java.io.IOException;
import java.util.List;

import static com.twu.biblioteca.controller.LibraryController.formatBookList;
import static com.twu.biblioteca.controller.LibraryController.formatMovieList;

/**
 * Created by jlli on 8/6/16.
 */
public class LoginView {
    public static UserController user = new UserController();

    public void login() throws IOException {
        Helper.printMsg("Please input your username:");
        String username = Helper.getInputMsg(System.in);
        Helper.printMsg("Please input you password:");
        String password = Helper.getInputMsg(System.in);
        if (user.Login(username, password)) {
            Helper.printMsg("Login success, Now you can borrow book!");
        } else {
            if (user.hasLoginUser())
                Helper.printMsg("You are alreadly isLogin!");
            else
                Helper.printMsg("Wrong username or password, please enter again");
        }
    }

    public void logout() {
        if (user.Logout()) {
            Helper.printMsg("Logout success. Thanks for using.");
        } else {
            Helper.printMsg("No User is isLogin. Please enter your option.");
        }
    }

    public void showUserInfo() {
        if (user.hasLoginUser()) {
            user.showUserInfo();
        } else {
            Helper.printMsg("No User is isLogin. Please enter your option.");
        }
    }

}
