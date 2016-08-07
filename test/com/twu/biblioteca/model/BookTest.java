package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by jlli on 8/7/16.
 */
public class BookTest {
    private Book book;

    @Before
    public void BuilderBook() {
        book = new Book(0, "Java First", new Date(2222), "Jake", 1);
    }

    @Test
    public void ShouldReturnBookWhenGiveBook() {
        assertEquals(0, book.getID());
        assertEquals("Java First", book.getName());
        assertEquals(new Date(2222), book.getPublishTime());
        assertEquals(1, book.getStatus());
    }

}
