package com.twu.biblioteca.dao;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;

import static com.twu.biblioteca.dao.LibraryDao.STATUS_AVAILABLE;

/**
 * Created by jlli on 8/13/16.
 */
public class MovieDao {
    public static LibraryDao libraryDao = new LibraryDao();

    public Movie findMovieByID(int movieID) {
        Movie movie = libraryDao.getAllMovie().stream().filter(b -> b.getID() == movieID).findFirst().orElse(null);
        return movie;
    }

    public boolean isAvailable(Movie movie) {
        return movie.getStatus().equals(STATUS_AVAILABLE);
    }
}
