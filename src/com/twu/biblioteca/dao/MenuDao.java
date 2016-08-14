package com.twu.biblioteca.dao;

import com.twu.biblioteca.helper.Helper;
import com.twu.biblioteca.model.Menu;

import java.util.List;

/**
 * Created by jlli on 8/14/16.
 */
public class MenuDao {
    private List<Menu> menus;

    public List<Menu> getAllMenu() {
        if(menus == null){
            menus = Helper.intializeMenus();
        }
        return menus;
    }
}
