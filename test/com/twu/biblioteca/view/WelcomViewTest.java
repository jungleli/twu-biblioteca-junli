package com.twu.biblioteca.view;

import com.twu.biblioteca.helper.Helper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by jlli on 8/7/16.
 */
public class WelcomViewTest {
    private String welcomeMSG;
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
    public void ShouldBeAbleToPrintWelcomMsg(){
        welcomeMSG = "Weclome to the Virtual Library!\n";
        WelcomeView welcomeView = new WelcomeView();
        welcomeView.getWELCOME();
        assertEquals(welcomeMSG, outContent.toString());
    }
}
