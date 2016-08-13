package com.twu.biblioteca.controller;

import com.twu.biblioteca.dao.BookDao;
import com.twu.biblioteca.dao.LibraryDao;
import com.twu.biblioteca.dao.MovieDao;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jlli on 8/6/16.
 */
public class LibraryController {
//    private static Library lib;
    private LibraryDao libraryDao = new LibraryDao();
    private BookDao bookDao = new BookDao();
    private MovieDao movieDao = new MovieDao();
    public static final String STATUS_AVAILABLE = "AVAILABLE";
    public static final String STATUS_ON_LOAD = "ONLOAD";

    private static String getFormatDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public List<String> listAllAvailableBooks() {
        return formatBookList(libraryDao.getAllAvailableBooks());
    }

    public List<String> listAllAvailableMovies() {
        return formatMovieList(libraryDao.getAllAvailableMovies());
    }

    public static List<String> formatMovieList(List<Movie> movies) {
        return movies.stream()
                    .map(m -> String.format("%-10d%-20s%-15s%-20s%-20s", m.getID(), m.getName(), m.getDirector(), m.getPublishYear(), m.getRating()))
                    .collect(Collectors.toList());
    }

    public static List<String> formatBookList(List<Book> books) {
        return books.stream()
                    .map(r -> String.format("%-10d%-20s%-15s%-20s%-20s", r.getID(), r.getName(), r.getAuthor(), getFormatDate(r.getPublishTime()), r.getStatus()))
                    .collect(Collectors.toList());
    }

    public boolean checkOutBook(int bookID) {
        if (bookDao.isValidBookID(bookID)) {
            Book book = bookDao.findBookByID(bookID);
            if (book != null && bookDao.isAvailable(book)) {
                bookDao.setToOnLoad(book);
                return true;
            }
        }
        return false;
    }

    public boolean checkInBook(int bookID) {
        if (bookDao.isValidBookID(bookID)) {
            Book book = bookDao.findBookByID(bookID);
            if (book != null && bookDao.isOnLoadBook(book)) {
                bookDao.setToAvailable(book);
                return true;
            }
        }
        return false;
    }
    public boolean checkOutMovie(int movieID) {
        if (movieDao.isValidMovieID(movieID)) {
            Movie movie = movieDao.findMovieByID(movieID);
            if (movie != null && movieDao.isAvailable(movie)) {
                movieDao.setToOnLoad(movie);
                return true;
            }
        }
        return false;
    }

    public boolean checkInMovie(int movieID) {
        if (movieDao.isValidMovieID(movieID)) {
            Movie movie = movieDao.findMovieByID(movieID);
            if (movie != null && movieDao.isOnLoadMovie(movie)) {
                movieDao.setToAvailable(movie);
                return true;
            }
        }
        return false;
    }

}
