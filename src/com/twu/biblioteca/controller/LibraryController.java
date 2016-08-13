package com.twu.biblioteca.controller;

import com.twu.biblioteca.dao.BookDao;
import com.twu.biblioteca.dao.LibraryDao;
import com.twu.biblioteca.dao.MovieDao;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.view.LoginView.user;

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

    private void addToUserBookList(Book book) {
        List<Book> userBookList = user.getUserBooks();
        if (userBookList == null) {
            userBookList = new ArrayList();
            userBookList.add(book);
            user.setUsersBooks(userBookList);
        } else {
            userBookList.add(book);
            user.setUsersBooks(userBookList);
        }
    }

    private void removeFromUserBookList(Book book) {
        List<Book> userBookList = user.getUserBooks();
        if (userBookList != null) {
            userBookList.remove(book);
            user.setUsersBooks(userBookList);
        }
    }

    private void addToUserMovieList(Movie movie) {
        List<Movie> userMovieList = user.getUserMovies();
        if (userMovieList == null) {
            userMovieList = new ArrayList();
            userMovieList.add(movie);
            user.setUsersMovies(userMovieList);
        } else {
            userMovieList.add(movie);
            user.setUsersMovies(userMovieList);
        }
    }

    private void removeFromUserMovieList(Movie movie) {
        List<Book> userBookList = user.getUserBooks();
        if (userBookList != null) {
            userBookList.remove(movie);
            user.setUsersBooks(userBookList);
        }
    }

    public boolean checkOutBook(int bookID) {
        if (bookDao.isValidBookID(bookID)) {
            Book book = bookDao.findBookByID(bookID);
            if (book != null && bookDao.isAvailable(book)) {
                bookDao.setToOnLoad(book);
//                addToUserBookList(book);
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
//                removeFromUserBookList(book);
                return true;
            }
        }
        return false;
    }
    public boolean checkOutMovie(int movieID) {
        if (movieID < 0 || movieID > libraryDao.getAllMovie().size())
            return false;
        Movie movie = movieDao.findMovieByID(movieID);
        if (movie != null && isMovieStatus(movie, STATUS_AVAILABLE)) {
            movie.setStatus(STATUS_ON_LOAD);
//            addToUserMovieList(movie);
            return true;
        }
        return false;
    }

    public boolean checkInMovie(int movieID) {
        if (movieID < 0 || movieID > libraryDao.getAllBooks().size())
            return false;
        Movie movie = movieDao.findMovieByID(movieID);
        if (movie != null && isMovieStatus(movie, STATUS_ON_LOAD)) {
            movie.setStatus(STATUS_AVAILABLE);
//            removeFromUserMovieList(movie);
            return true;
        }
        return false;
    }


    private boolean isMovieStatus(Movie movie, String status) {
        return movie.getStatus().equals(status);
    }
}
