package com.twu.biblioteca.model;

/**
 * Created by jlli on 8/7/16.
 */
public class Movie {
    private int ID;
    private String Name;
    private String PublishYear;
    private String Director;
    private String Rating;
    private String Status;

    public Movie(int ID, String name, String publishYear, String director, String rating, String status) {
        this.ID = ID;
        Name = name;
        PublishYear = publishYear;
        Director = director;
        Rating = rating;
        Status = status;
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

    public String getPublishYear() {
        return PublishYear;
    }

    public void setPublishYear(String publishYear) {
        PublishYear = publishYear;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
