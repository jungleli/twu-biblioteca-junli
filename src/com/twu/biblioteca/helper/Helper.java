package com.twu.biblioteca.helper;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by jlli on 8/6/16.
 */
public class Helper {
    public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static String getInputMsg(InputStream in) throws IOException {
        return new Scanner(in).nextLine().trim();
    }

    public static int getInputInt(InputStream in) {
        try {
            return new Scanner(in).nextInt();
        } catch (InputMismatchException e) {
            return -999;
        }
    }

    public static List<Book> initializeBooks() {
        return Arrays.asList(
                new Book(1, "Java Plus", new Date(), "Jack", 1),
                new Book(2, "C Plus", new Date(), "Terry", 1),
                new Book(3, "Python Plus", new Date(), "Shark", 1),
                new Book(4, "Doosh Plus", new Date(), "Obama", 1)
        );
    }

    public static List<Menu> intializeMenus() {
        return Arrays.asList(
                new Menu(1, "List Books"),
                new Menu(2, "Check out books"),
                new Menu(3, "Check in books"),
                new Menu(4, "Login"),
                new Menu(5, "User Checked List"),
                new Menu(6, "Logout"),
                new Menu(7, "Quit")
        );
    }

    public static List<User> intializeUsers() {
        return Arrays.asList(
                new User(1, "Lisa", "123456", "LOGOUT", null),
                new User(2, "Tom", "123456", "LOGOUT", null),
                new User(3, "Bob", "123456", "LOGOUT", null),
                new User(4, "1", "1", "LOGOUT", null)
        );
    }
}
