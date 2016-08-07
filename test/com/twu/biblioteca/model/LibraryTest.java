package com.twu.biblioteca.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by jlli on 8/7/16.
 */
public class LibraryTest {
    private Library library;
    private List<Book> bookList;


    @Before
    public void BuildLibrary(){
        library = new Library();
        bookList = Arrays.asList(
                new Book(1, "Java Plus", new Date(), "Jack", "AVAILABLE"),
                new Book(2, "C Plus", new Date(), "Terry", "AVAILABLE")
        );
        library.setBooks(bookList);
    }

    @Test
    public void ShouldReturnBooksByGivenLibrary() {
        Assert.assertEquals(bookList, library.getBooks());
    }
}
