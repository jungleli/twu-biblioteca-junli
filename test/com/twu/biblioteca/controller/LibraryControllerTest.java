package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
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

    @Before
    public void BuildLibrary(){
        libraryController = new LibraryController();
        bookList = Arrays.asList(
                new Book(1, "Java Plus", new Date(), "Jack", 1),
                new Book(2, "C Plus", new Date(), "Terry", 0)
        );
        libraryController.checkOutBook(1);
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

}
