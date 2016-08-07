package com.twu.biblioteca.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jlli on 8/7/16.
 */
public class UserontrollerTest {
    private static UserController userController;
    @Before
    public void BuilderLoginUser() {
        userController = new UserController();
        userController.Login("Lisa", "123456");
    }

    @After
    public void RestoreLoginUser() {
        userController = new UserController();
        userController.Logout();
    }


    @Test
    public void ShouldBeAbleToFindLoginUser() {
        Assert.assertTrue(userController.findUserByName("Lisa").getStatus() == "LOGIN");
    }

    @Test
    public void ShouldBeAbleTofindLoginUser() {
        Assert.assertTrue(userController.findLoginUser());
    }

    @Test
    public void ShouldBeAbleToLogOut() {
        Assert.assertTrue(userController.Logout());
    }

}
