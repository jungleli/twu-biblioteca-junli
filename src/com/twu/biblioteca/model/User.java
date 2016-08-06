package com.twu.biblioteca.model;

import java.util.List;

/**
 * Created by jlli on 8/6/16.
 */
public class User {
    private int ID;
    private String Name;
    private String Password;
    private List<Book> BookList;

    public int getID() {
        return ID;
    }

    public User(int ID, String name, String password) {
        this.ID = ID;
        Name = name;
        Password = password;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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
