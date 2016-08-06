package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.controller.UserController;
import com.twu.biblioteca.helper.Helper;

/**
 * Created by jlli on 8/6/16.
 */
public class CheckBookView {
    LibraryController libraryController = new LibraryController();
    boolean isHasUserLogin = new UserController().findLoginUser();

    public void checkOutBookByID() {
        if (isHasUserLogin) {
            Helper.printMsg("Please enter the bookID to checkOut");
            int bookID = Helper.getInputInt(System.in);
            if (libraryController.checkOutBook(bookID)) {
                Helper.printMsg("Thank you! Enjoy the book");
            } else {
                Helper.printMsg("That book is not available. Which do you want next:");
            }
        }else{
            Helper.printMsg("You are not Login, Please Login first.");
        }
    }

    public void checkInBookByID() {
        if (isHasUserLogin) {
            Helper.printMsg("Please enter the bookID to checkIn");
            int bookID = Helper.getInputInt(System.in);
            if (libraryController.checkInBook(bookID)) {
                Helper.printMsg("Thank you for returning the book.");
            } else Helper.printMsg("That is not a valid book to return.");
        } else {
            Helper.printMsg("You are not Login, Please Login first.");
        }
    }
}
