package com.twu.biblioteca.model;

import java.util.List;

/**
 * Created by jlli on 8/6/16.
 */
public class Library {
    private List<Book> Books;
    private List<Movie> Movies;

    public Library() {
    }

    public Library(List<Book> books) {
        Books = books;
    }

    public Library(List<Book> books, List<Movie> movies) {
        Books = books;
        Movies = movies;
    }

    public List<Book> getBooks() {
        return Books;
    }

    public void setBooks(List<Book> books) {
        Books = books;
    }

    public List<Movie> getMovies() {
        return Movies;
    }

    public void setMovies(List<Movie> movies) {
        Movies = movies;
    }
}

