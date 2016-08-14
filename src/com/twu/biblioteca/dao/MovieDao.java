package com.twu.biblioteca.dao;

import com.twu.biblioteca.model.Movie;

import static com.twu.biblioteca.dao.LibraryDao.STATUS_AVAILABLE;
import static com.twu.biblioteca.dao.LibraryDao.STATUS_ON_LOAD;

/**
 * Created by jlli on 8/13/16.
 */
public class MovieDao {
    public static LibraryDao libraryDao = new LibraryDao();

    public Movie findMovieByID(int movieID) {
        Movie movie = libraryDao.getAllMovies().stream().filter(b -> b.getID() == movieID).findFirst().orElse(null);
        return movie;
    }

    public boolean isAvailable(Movie movie) {
        return movie.getStatus().equals(STATUS_AVAILABLE);
    }

    public boolean isValidMovieID(int id) {
        return id < libraryDao.getAllMovies().size() && id > 0;
    }

    public boolean isOnLoadMovie(Movie movie) {
        return movie.getStatus().equals(STATUS_ON_LOAD);
    }

    public void setToAvailable(Movie movie) {
        movie.setStatus(STATUS_AVAILABLE);
    }

    public void setToOnLoad(Movie movie) {
        movie.setStatus(STATUS_ON_LOAD);
    }
}
