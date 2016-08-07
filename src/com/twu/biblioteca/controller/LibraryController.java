package com.twu.biblioteca.controller;

import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
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
    private static Library lib;
    public static final String STATUS_AVAILABLE = "AVAILABLE";
    public static final String STATUS_ON_LOAD = "ONLOAD";

    public Library getLibrary() {
        if (lib == null) {
            lib = new Library(Helper.initializeBooks(), Helper.initializeMovies());
        }
        return lib;
    }

    public List<Book> getAllBooks() {
        return getLibrary().getBooks();
    }

    public List<Movie> getAllMovie() {
        return getLibrary().getMovies();
    }

    private static String getFormatDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }


    public List<String> listAllAvailableBooks(List<Book> books) {
        return formatBookList(books.stream().filter(b -> isBookStatus(b, STATUS_AVAILABLE)).collect(Collectors.toList()));
    }

    public List<String> listAllAvailableMovies(List<Movie> movies) {
        return formatMovieList(movies.stream().filter(m -> isMovieStatus(m, STATUS_AVAILABLE)).collect(Collectors.toList()));
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

    public Book findBookByID(int bookID) {
        Book book = getAllBooks().stream().filter(b -> b.getID() == bookID).findFirst().orElse(null);
        return book;
    }

    public Movie findMovieByID(int movieID) {
        Movie movie = getAllMovie().stream().filter(b -> b.getID() == movieID).findFirst().orElse(null);
        return movie;
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
        if (bookID < 0 || bookID > getAllBooks().size())
            return false;
        Book book = findBookByID(bookID);
        if (book != null && isBookStatus(book, STATUS_AVAILABLE)) {
            book.setStatus(STATUS_ON_LOAD);
            addToUserBookList(book);
            return true;
        }
        return false;
    }

    public boolean checkInBook(int bookID) {
        if (bookID < 0 || bookID > getAllBooks().size())
            return false;
        Book book = findBookByID(bookID);
        if (book != null && isBookStatus(book, STATUS_ON_LOAD)) {
            book.setStatus(STATUS_AVAILABLE);
            removeFromUserBookList(book);
            return true;
        }
        return false;
    }
    public boolean checkOutMovie(int movieID) {
        if (movieID < 0 || movieID > getAllMovie().size())
            return false;
        Movie movie = findMovieByID(movieID);
        if (movie != null && isMovieStatus(movie, STATUS_AVAILABLE)) {
            movie.setStatus(STATUS_ON_LOAD);
            addToUserMovieList(movie);
            return true;
        }
        return false;
    }

    public boolean checkInMovie(int movieID) {
        if (movieID < 0 || movieID > getAllBooks().size())
            return false;
        Movie movie = findMovieByID(movieID);
        if (movie != null && isMovieStatus(movie, STATUS_ON_LOAD)) {
            movie.setStatus(STATUS_AVAILABLE);
            removeFromUserMovieList(movie);
            return true;
        }
        return false;
    }

    private boolean isBookStatus(Book book, String status) {
        return book.getStatus().equals(status);
    }

    private boolean isMovieStatus(Movie movie, String status) {
        return movie.getStatus().equals(status);
    }
}
