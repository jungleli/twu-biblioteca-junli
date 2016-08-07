package com.twu.biblioteca.helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by jlli on 8/7/16.
 */
public class HelperTest {
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
    public void ShouldReturnMsgByGivenMsg() {
        Helper.printMsg("hello");
        assertEquals("hello\n", outContent.toString());
    }

    @Test
    public void shouldBeAbleToGetIntNumByInput() {
        Helper helper = new Helper();
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(1, helper.getInputInt(in));
    }
    @Test
    public void shouldBeAbleToGetStrByInput() {
        Helper helper = new Helper();
        ByteArrayInputStream in = new ByteArrayInputStream("string".getBytes());
        System.setIn(in);
        try {
            assertEquals("string", helper.getInputMsg(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ShouldReturnMenuByInit(){
        assertEquals(true, Helper.intializeMenus().size() > 0);
    }

    @Test
    public void ShouldReturnLibraryByInit(){
        assertEquals(true, Helper.initializeBooks().size() > 0);
    }

    @Test
    public void ShouldReturnUsersByInit(){
        assertEquals(true, Helper.intializeUsers().size() > 0);
    }
}

