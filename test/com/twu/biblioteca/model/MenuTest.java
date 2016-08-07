package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jlli on 8/7/16.
 */
public class MenuTest {
    private Menu menu;

    @Test
    public void ShouldReturnMenuByGiveMenu() {
        menu = new Menu(0, "Login");
        assertEquals(0, menu.getID());
        assertEquals("Login", menu.getName());
    }
}
