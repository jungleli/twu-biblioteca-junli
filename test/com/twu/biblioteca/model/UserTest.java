package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jlli on 8/7/16.
 */
public class UserTest {
    private User user;

    @Before
    public void BuildeUser() {
        user = new User(0, "Lisa", "123456", "LOGOUT", null);
    }

    @Test
    public void ShouldReturnUserByGiveUser() {
        assertEquals(0, user.getID());
        assertEquals("Lisa", user.getName());
        assertEquals("123456", user.getPassword());
    }
}
