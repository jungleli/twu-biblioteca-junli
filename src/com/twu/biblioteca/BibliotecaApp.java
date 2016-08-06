package com.twu.biblioteca;

import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.view.MenuView;
import com.twu.biblioteca.view.WelcomeView;

import java.io.IOException;

public class BibliotecaApp {

    public static void main(String[] args) {

        WelcomeView.getWELCOME();

        MenuView menuView = new MenuView();
        menuView.printAllMenu();

        Helper.printMsg("=====Please input a valid menu index:======");
        try {
            while (getInputMenuItem(menuView) != 5) {
                getInputMenuItem(menuView);
            }
        } catch (IOException exception) {
        }
    }

    private static int getInputMenuItem(MenuView menuView) throws IOException {
        int menuItem = Helper.getInputInt(System.in);
        menuView.dispatchMenu(menuItem);
        Helper.printMsg("=====Please input a valid menu index:======");
        menuView.printAllMenu();
        return menuItem;
    }
}
