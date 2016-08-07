package com.twu.biblioteca.model;

import java.util.List;

/**
 * Created by jlli on 8/6/16.
 */
public class User {
    private int ID;
    private String Name;
    private String Password;
    private String Email;
    private String PhoneNum;
    private String Status;
    private List<Book> BookList;
    private List<Movie> MovieList;

    public int getID() {
        return ID;
    }

    public User(int ID, String name, String password, String status) {
        this.ID = ID;
        Name = name;
        Password = password;
        Status = status;
    }

    public User(int ID, String name, String password, String status, List<Book> bookList) {
        this.ID = ID;
        Name = name;
        Password = password;
        Status = status;
        BookList = bookList;
    }

    public User(int ID, String name, String password, String status, List<Book> bookList, List<Movie> movieList) {
        this.ID = ID;
        Name = name;
        Password = password;
        Status = status;
        BookList = bookList;
        MovieList = movieList;
    }

    public User(int ID, String name, String password, String email, String phoneNum, String status, List<Book> bookList, List<Movie> movieList) {
        this.ID = ID;
        Name = name;
        Password = password;
        Email = email;
        PhoneNum = phoneNum;
        Status = status;
        BookList = bookList;
        MovieList = movieList;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<Book> getBookList() {
        return BookList;
    }

    public void setBookList(List<Book> bookList) {
        BookList = bookList;
    }

    public List<Movie> getMovieList() {
        return MovieList;
    }

    public void setMovieList(List<Movie> movieList) {
        MovieList = movieList;
    }
}
