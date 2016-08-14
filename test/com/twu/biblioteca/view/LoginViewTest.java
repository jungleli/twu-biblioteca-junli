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
public class LoginViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String logOutMsg;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void ShouldBeShowLogMsgDependsOnLoginStatus() {
        logOutMsg = "No User is isLogin. Please enter your option.\n";
        LoginView loginView = new LoginView();
        loginView.logout();
        Assert.assertEquals(logOutMsg.trim(), outContent.toString().trim());
    }
}
