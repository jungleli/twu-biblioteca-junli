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
public class ListBooksViewTest {
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
        ListBooksView listBooksView = new ListBooksView();
        listBooksView.printBooklist();
        Assert.assertEquals(true, outContent.toString().contains("Java Plus"));
    }
}
