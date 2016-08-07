package com.twu.biblioteca.controller;

import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.view.LoginView.user;

/**
 * Created by jlli on 8/6/16.
 */
public class LibraryController {
    private static Library lib;

    public Library getLibrary() {
        if (lib == null) {
            lib = new Library();
            lib.setBooks(Helper.initializeBooks());
        }
        return lib;
    }


    private static String getFormatDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }


    public List<String> listAllAvailableBooks(List<Book> books) {
        return formatBookList(books.stream().filter(b -> b.getStatus() == 1).collect(Collectors.toList()));
    }

    public static List<String> formatBookList(List<Book> books) {
        return books.stream()
                    .map(r -> String.format("%-10d%-20s%-20s%-10s", r.getID(), r.getName(), r.getAuthor(), getFormatDate(r.getPublishTime())))
                    .collect(Collectors.toList());
    }

    public List<Book> getAllBooks() {
        return getLibrary().getBooks();
    }

    public Book findBookByID(int bookID) {
        Book book = getAllBooks().stream().filter(b -> b.getID() == bookID).findFirst().orElse(null);
        return book;
    }

    private void addToUserBookList(Book book) {
        List<Book> userBookList = user.getUserBooks();
        if (userBookList == null) {
            userBookList = new ArrayList();
            userBookList.add(book);
            user.setUsersBooks(userBookList);
        } else {
            userBookList.add(book);
            user.setUsersBooks(userBookList);
        }
    }

    private void removeFromUserBookList(Book book) {
        List<Book> userBookList = user.getUserBooks();
        if (userBookList != null) {
            userBookList.remove(book);
            user.setUsersBooks(userBookList);
        }
    }

    public boolean checkOutBook(int bookID) {
        if (bookID < 0 || bookID > getAllBooks().size())
            return false;
        Book book = findBookByID(bookID);
        if (book != null && book.getStatus() == 1) {
            book.setStatus(0);
            addToUserBookList(book);
            return true;
        }
        return false;
    }

    public boolean checkInBook(int bookID) {
        if (bookID < 0 || bookID > getAllBooks().size())
            return false;
        Book book = findBookByID(bookID);
        if (book != null && book.getStatus() == 0) {
            book.setStatus(1);
            removeFromUserBookList(book);
            return true;
        }
        return false;
    }
}
