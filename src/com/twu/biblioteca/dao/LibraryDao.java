package com.twu.biblioteca.dao;

import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jlli on 8/13/16.
 */
public class LibraryDao {
    private static Library libraryInit;
    private static BookDao bookDao = new BookDao();
    private static MovieDao movieDao = new MovieDao();

    public static final String STATUS_AVAILABLE = "AVAILABLE";
    public static final String STATUS_ON_LOAD = "ONLOAD";

    public Library getLibbrary() {
        if(libraryInit == null){
            libraryInit = new Library(Helper.initializeBooks(), Helper.initializeMovies());
        }
        return libraryInit;
    }

    public List<Book> getAllBooks() {
        return getLibbrary().getBooks();
    }

    public List<Movie> getAllMovie() {
        return getLibbrary().getMovies();
    }

    public List<Book> getAllAvailableBooks() {
        return getAllBooks().stream().filter(b -> bookDao.isAvailable(b)).collect(Collectors.toList());
    }

    public List<Movie> getAllAvailableMovies() {
        return getAllMovie().stream().filter(m -> movieDao.isAvailable(m)).collect(Collectors.toList());
    }

}
