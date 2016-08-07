package com.twu.biblioteca.controller;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jlli on 8/7/16.
 */
public class MenuControllerTest {
    private static MenuController menuController;

    @Test
    public void ShouldBeAbleToGetAllMenus() {
        menuController = new MenuController();
        Assert.assertTrue(menuController.listAllMenu().size()>0);
    }

    @Test
    public void ShouldBeAbleToShowAllMenus() {
        menuController = new MenuController();
        String allMenu = menuController.showMenu();
        Assert.assertTrue(!allMenu.isEmpty() && allMenu.contains("||"));
    }
}
