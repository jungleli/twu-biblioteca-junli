package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jlli on 8/7/16.
 */
public class MenuTest {
    private Menu menu;

    @Before
    public void BuildMenu() {
        menu = new Menu(0, "isLogin");
    }

    @Test
    public void ShouldReturnMenuByGiveMenu() {
        assertEquals(0, menu.getID());
        assertEquals("isLogin", menu.getName());
    }
}
