package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.helper.Helper;

/**
 * Created by jlli on 8/6/16.
 */
public class ListBooksView {

    LibraryController libDispatcher = new LibraryController();

    public void printBooklist() {
        Helper.printMsg(String.format("%-10s%-20s%-20s%-10s", "BOOK ID", "BOOK NAME", "AUTHOR", "STATUS"));
        libDispatcher.listAllAvailableBooks(libDispatcher.getLibrary().getBooks()).forEach(
                r -> Helper.printMsg(r));
    }
}


