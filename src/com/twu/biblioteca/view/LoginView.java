package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.UserController;
import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.Book;

import java.io.IOException;
import java.util.List;

import static com.twu.biblioteca.controller.LibraryController.formatBookList;

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
            if (user.findLoginUser())
                Helper.printMsg("You are alreadly Login!");
            else
                Helper.printMsg("Wrong username or password, please enter again");
        }
    }

    public void logout() {
        if (user.findLoginUser()) {
            user.getLoginUser().setStatus("LOGOUT");
            Helper.printMsg("Logout success. Thanks for using.");
        } else {
            Helper.printMsg("No User is Login. Please enter your option.");
        }
    }

    public void showUserCheckedBooks() {
        if (user.findLoginUser()) {
            List<Book> userBookList = user.getUserBooks();
            if (userBookList != null && userBookList.size() > 0) {
                Helper.printMsg(String.format("%-10s%-20s%-20s%-10s", "BOOK ID", "BOOK NAME", "AUTHOR", "STATUS"));
                formatBookList(userBookList).forEach(
                        r -> Helper.printMsg(r));
               } else {
                Helper.printMsg("You have not borrow any books.");
            }
        } else {
            Helper.printMsg("No User is Login. Please enter your option.");
        }
    }
}
