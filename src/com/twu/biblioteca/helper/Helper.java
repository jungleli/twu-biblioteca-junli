package com.twu.biblioteca.helper;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by jlli on 8/6/16.
 */
public class Helper {

    public static void printMsg(String msg)
    {
        System.out.println(msg);
    }

    public static List<Book> initializeData()
    {
        return Arrays.asList(
           new Book(1, "Java Plus",new Date(), "Jack",1),
           new Book(2, "C Plus",new Date(), "Terry",1),
           new Book(3, "Python Plus",new Date(), "Shark",1),
           new Book(4, "Doosh Plus",new Date(), "Obama",1)
        );
    }
}
