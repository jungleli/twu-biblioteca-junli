package com.twu.biblioteca;

import com.twu.biblioteca.view.ListBooks;
import com.twu.biblioteca.view.Welcome;

public class BibliotecaApp {

    public static void main(String[] args) {
//        System.out.println("Hello, world!");
        Welcome.getWELCOME();

        ListBooks lb = new ListBooks();
        lb.printBooklist();
    }
}
