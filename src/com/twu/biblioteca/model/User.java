package com.twu.biblioteca.model;

import java.util.List;

/**
 * Created by jlli on 8/6/16.
 */
public class User {
    private int ID;
    private String Name;
    private List<Book> BookList;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Book> getBookList() {
        return BookList;
    }

    public void setBookList(List<Book> bookList) {
        BookList = bookList;
    }
}
