package com.twu.biblioteca.model;

import java.util.List;

/**
 * Created by jlli on 8/6/16.
 */
public class Library {
    private List<Book> Books;

    public Library() {
    }

    public Library(List<Book> books) {
        Books = books;
    }

    public List<Book> getBooks() {
        return Books;
    }

    public void setBooks(List<Book> books) {
        Books = books;
    }
}

