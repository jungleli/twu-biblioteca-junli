package com.twu.biblioteca.controller;

import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.Library;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jlli on 8/6/16.
 */
public class LibraryController {
    private static Library lib;

    public Library getLibrary()
    {
        if(lib ==null) {
            lib = new Library();
            lib.setBooks(Helper.initializeBooks());
        }
        return lib;
    }

    public List<String> listAllBooks() {
        return getLibrary().getBooks().stream().filter(b -> b.getStatus() ==1)
                .map(r -> String.format("%-10d%-20s%-20s%-10d", r.getID(), r.getName(), r.getAuthor(), r.getStatus()))
                .collect(Collectors.toList());
    }
}
