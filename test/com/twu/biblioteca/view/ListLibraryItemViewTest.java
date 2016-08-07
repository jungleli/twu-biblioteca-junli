package com.twu.biblioteca.view;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by jlli on 8/7/16.
 */
public class ListLibraryItemViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void ShouldBeAbleShowBookList() {
        ListLibraryItemView listBooksView = new ListLibraryItemView();
        listBooksView.printBooklist();
        Assert.assertTrue(outContent.toString().contains("C Plus".trim()));
    }

    @Test
    public void ShouldBeAbleShowMovieList() {
        ListLibraryItemView listMoviesView = new ListLibraryItemView();
        listMoviesView.printMovielist();
        Assert.assertTrue(outContent.toString().contains("Lost"));
    }
}
