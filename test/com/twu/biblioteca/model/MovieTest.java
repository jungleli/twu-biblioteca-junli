package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by jlli on 8/7/16.
 */
public class MovieTest {
    private Movie movie;

    @Before
    public void BuilderBook() {
        movie = new Movie(0, "Lost", "2015", "Rose", "8", "AVAILABLE");
    }

    @Test
    public void ShouldReturnBookWhenGiveBook() {
        assertEquals(0, movie.getID());
        assertEquals("Lost", movie.getName());
        assertEquals("2015", movie.getPublishYear());
        assertEquals("AVAILABLE", movie.getStatus());
    }
}

