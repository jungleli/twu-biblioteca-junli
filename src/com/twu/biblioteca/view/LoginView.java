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
            if (user.findLoginUser())
                Helper.printMsg("You are alreadly Login!");
            else
                Helper.printMsg("Wrong username or password, please enter again");
        }
    }

    public void logout() {
        if (user.Logout()) {
            Helper.printMsg("Logout success. Thanks for using.");
        } else {
            Helper.printMsg("No User is Login. Please enter your option.");
        }
    }

    public void showUserInfo() {
        if (user.findLoginUser()) {
            User u = user.getLoginUser();
            Helper.printMsg(String.format("UserName:%-10s Email:%-20s PhoneNum:%-20s", u.getName(), u.getEmail(), u.getPhoneNum()));
        } else {
            Helper.printMsg("No User is Login. Please enter your option.");
        }
    }

    public void showUserCheckedBooksAndMovies() {
        if (user.findLoginUser()) {
            List<Book> userBookList = user.getUserBooks();
            List<Movie> userMovieList = user.getUserMovies();
            if (userBookList != null && userBookList.size() > 0) {
                Helper.printMsg(String.format("%-10s%-20s%-15s%-20s%-%20s", "BOOK ID", "BOOK NAME", "AUTHOR", "PUBLISH DATE", "STATUS"));
                formatBookList(userBookList).forEach(
                        r -> Helper.printMsg(r));
               } else {
                Helper.printMsg("You have not borrow any books.");
            }
            if (userMovieList != null && userMovieList.size() > 0) {
                Helper.printMsg(String.format("%-10s%-20s%-15s%-20s%-%20s", "Movie ID", "MOVIE NAME", "DIRECTOR", "PUBLISH DATE", "RATING"));
                formatMovieList(userMovieList).forEach(
                        r -> Helper.printMsg(r));
            } else {
                Helper.printMsg("You have not borrow any books.");
            }
        } else {
            Helper.printMsg("No User is Login. Please enter your option.");
        }
    }
}
