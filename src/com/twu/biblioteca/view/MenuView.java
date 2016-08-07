package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.helper.Helper;

import java.io.IOException;

/**
 * Created by jlli on 8/6/16.
 */
public class MenuView {
    MenuController menuDispatch = new MenuController();

    public void printAllMenu()
    {
        Helper.printMsg(menuDispatch.showMenu());
    }

    public void dispatchMenu(int menuItem)
    {
        LoginView loginView = new LoginView();
        switch (menuItem)
        {
            case 1:
                new ListLibraryItemView().printBooklist();
                break;
            case 2:
                new ListLibraryItemView().printMovielist();
                break;
            case 3:
                new CheckLibraryItemView().checkOutBookByID();
                break;
            case 4:
                new CheckLibraryItemView().checkOutMoiveByID();
                break;
            case 5:
                new CheckLibraryItemView().checkInBookByID();
                break;
            case 6:
                new CheckLibraryItemView().checkInMovieByID();
                break;
            case 7:
                try {
                    loginView.login();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 8:
                loginView.showUserInfo();
                break;
            case 9:
                loginView.logout();
                break;
            case 0:
                Helper.printMsg("Quit success! Bye");
                break;
            default:
                System.out.println("Invalid menu item, please input it again:");
                printAllMenu();
                break;
        }
    }
}
