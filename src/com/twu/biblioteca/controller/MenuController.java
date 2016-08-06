package com.twu.biblioteca.controller;

import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.Menu;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by jlli on 8/6/16.
 */
public class MenuController {

    public List<Menu> getAllMenu()
    {
       return Helper.intializeMenus();
    }

    public List<String> listAllMenu(){
        return getAllMenu().stream().map(m -> String.format("%-2d: %-5s", m.getID(), m.getName())).collect(Collectors.toList());
    }

    public String showMenu() {
        return String.join(" || ", listAllMenu());
    }
}
