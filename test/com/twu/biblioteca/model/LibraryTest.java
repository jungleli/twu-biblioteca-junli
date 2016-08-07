package com.twu.biblioteca.model;

import org.junit.Test;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Created by jlli on 8/7/16.
 */
public class LibraryTest {
    private Library library;

    @Test
    public void ShouldReturnBooksByGivenLibrary() {
        List<Book> bookList = Arrays.asList(
                new Book(1, "Java Plus", new Date(), "Jack", 1),
                new Book(2, "C Plus", new Date(), "Terry", 1)
        );
        library = new Library(bookList);
        assertEquals(2, library.getBooks().size());
    }
}
