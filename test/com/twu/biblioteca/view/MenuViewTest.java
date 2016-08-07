package com.twu.biblioteca.view;

import com.twu.biblioteca.helper.Helper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by jlli on 8/7/16.
 */
public class MenuViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String menuItems;
    private int menuItem;
    private String tipMsg;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void ShouldBeShowMenuItems(){
        menuItems = "1 : List Books || 2 : Check out books || 3 : Check in books || 4 : Login || 5 : User Checked List || 6 : Logout || 7 : Quit\n";
        MenuView menuView = new MenuView();
        menuView.printAllMenu();
        Assert.assertEquals(menuItems.trim(), outContent.toString().trim());
    }

    @Test
    public void ShouldBeAbleToDispatchMenu(){
        menuItem = 7;
        tipMsg = "Quit success! Bye\n";
        MenuView menuView = new MenuView();
        menuView.dispatchMenu(menuItem);
        Assert.assertEquals(tipMsg.trim(), outContent.toString().trim());
    }
}
