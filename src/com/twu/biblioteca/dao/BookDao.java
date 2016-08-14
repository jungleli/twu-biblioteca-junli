package com.twu.biblioteca.dao;

import com.twu.biblioteca.model.Book;

import static com.twu.biblioteca.dao.LibraryDao.STATUS_AVAILABLE;
import static com.twu.biblioteca.dao.LibraryDao.STATUS_ON_LOAD;
import static com.twu.biblioteca.dao.MovieDao.libraryDao;

/**
 * Created by jlli on 8/13/16.
 */
public class BookDao {

    public Book findBookByID(int bookID) {
        Book book = libraryDao.getAllBooks().stream().filter(b -> b.getID() == bookID).findFirst().orElse(null);
        return book;
    }

    public boolean isAvailable(Book book) {
        return book.getStatus().equals(STATUS_AVAILABLE);
    }

    public boolean isValidBookID(int id) {
        return id < libraryDao.getAllBooks().size() && id > 0;
    }

    public boolean isOnLoadBook(Book book) {
        return book.getStatus().equals(STATUS_ON_LOAD);
    }

    public void setToAvailable(Book book) {
        book.setStatus(STATUS_AVAILABLE);
    }

    public void setToOnLoad(Book book) {
        book.setStatus(STATUS_ON_LOAD);
    }


}
