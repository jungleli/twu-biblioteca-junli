package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by jlli on 8/7/16.
 */
public class LibraryControllerTest {
    private static LibraryController libraryController;
    private List<Book> bookList;
    private List<Movie> movieList;

    @Before
    public void BuildLibrary(){
        libraryController = new LibraryController();
        bookList = Arrays.asList(
                new Book(1, "Java Plus", new Date(), "Jack", "AVAILABLE"),
                new Book(2, "C Plus", new Date(), "Terry", "ONLOAD")
        );

        movieList = Arrays.asList(
                new Movie(1, "Augest", "2016", "Jack", "1", "AVAILABLE"),
                new Movie(2, "Jane", "2014", "Mike", "5", "AVAILABLE")
                );

        libraryController.checkOutBook(1);
        libraryController.checkOutMovie(1);
    }

    @After
    public void ReStoreLibrary() {
        libraryController.checkInBook(2);
    }

    @Test
    public void ShouldBeAbleGetAllAvailabeLibraryBooks() {
        Assert.assertTrue(libraryController.listAllAvailableBooks(bookList).stream().anyMatch(i->i.contains("Java Plus")));
        Assert.assertFalse(libraryController.listAllAvailableBooks(bookList).stream().anyMatch(i->i.contains("C Plus")));
    }

    @Test
    public void ShouldBeAbleToCheckOutBook () {
        Assert.assertTrue(libraryController.checkOutBook(2));
    }

    @Test
    public void ShouldBeAbleToCheckInBook() {
        Assert.assertTrue(libraryController.checkInBook(1));
    }

    @Test
    public void ShouldBeAbleToCheckOutMovie () {
        Assert.assertTrue(libraryController.checkOutMovie(2));
    }

    @Test
    public void ShouldBeAbleToCheckInMovie() {
        Assert.assertTrue(libraryController.checkInMovie(1));
    }

}
