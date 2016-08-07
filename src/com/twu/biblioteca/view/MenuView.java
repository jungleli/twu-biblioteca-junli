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

//    public void dispatchMenu(int menuItem) {
//        menuDispatch.dispatchMenu(menuItem);
//    }

    public void dispatchMenu(int menuItem)
    {
        LoginView loginView = new LoginView();
        switch (menuItem)
        {
            case 1:
                new ListBooksView().printBooklist();
                break;
            case 2:
                new CheckBookView().checkOutBookByID();
                break;
            case 3:
                new CheckBookView().checkInBookByID();
                break;
            case 4:
                try {
                    loginView.login();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                loginView.showUserCheckedBooks();
                break;
            case 6:
                loginView.logout();
                break;
            case 7:
                Helper.printMsg("Quit success! Bye");
                break;
            default:
                System.out.println("Invalid menu item, please input it again:");
                printAllMenu();
                break;
        }
    }
}
