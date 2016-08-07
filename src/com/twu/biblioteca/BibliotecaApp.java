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

        try {
            int menuItem = getInputMenuItem();
            while (menuItem != 7) {
                dispatchInputMenuItem(menuView, menuItem);
                menuItem = getInputMenuItem();
            }
        } catch (IOException exception) {
        }
    }

    private static void dispatchInputMenuItem(MenuView menuView, int menuItem) throws IOException {
        menuView.dispatchMenu(menuItem);
        menuView.printAllMenu();
    }

    private static int getInputMenuItem() throws IOException {
        Helper.printMsg("=====Please input a valid menu index:======");
        return Helper.getInputInt(System.in);
    }
}
