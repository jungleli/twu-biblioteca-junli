package com.twu.biblioteca.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by jlli on 8/7/16.
 */
public class UserTest {
    private User user;

    @Test
    public void ShouldReturnUserByGiveUser() {
        user = new User(0, "Lisa", "123456", "LOGOUT", null);
        assertEquals(0, user.getID());
        assertEquals("Lisa", user.getName());
        assertEquals("123456", user.getPassword());
    }
}
