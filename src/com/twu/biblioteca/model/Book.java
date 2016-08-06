package com.twu.biblioteca.model;

import java.util.Date;

/**
 * Created by jlli on 8/6/16.
 */
public class Book {
    private int ID;
    private String Name;
    private Date PublishTime;
    private String Author;
    private int status;

    public Book(int ID, String name, Date publishTime, String author, int status) {
        this.ID = ID;
        Name = name;
        PublishTime = publishTime;
        Author = author;
        this.status = status;
    }

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

    public Date getPublishTime() {
        return PublishTime;
    }

    public void setPublishTime(Date publishTime) {
        PublishTime = publishTime;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
