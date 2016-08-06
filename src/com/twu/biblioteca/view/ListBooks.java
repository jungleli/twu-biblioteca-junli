package com.twu.biblioteca.view;

import java.util.List;
import java.util.stream.Collectors;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;

/**
 * Created by jlli on 8/6/16.
 */
public class ListBooks {

    LibraryController libDispatcher = new LibraryController();

    public void printBooklist() {
        Helper.printMsg(String.format("%-10s%-20s%-20s%-10s", "BOOK ID", "BOOK NAME", "AUTHOR", "STATUS"));
        libDispatcher.listAllBooks().forEach(
                r -> Helper.printMsg(r));
    }
}


