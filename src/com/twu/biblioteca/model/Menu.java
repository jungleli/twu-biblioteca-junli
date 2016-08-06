package com.twu.biblioteca.model;

import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

/**
 * Created by jlli on 8/6/16.
 */
public class Menu {
    private int ID;

    private String Name;

    public Menu(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
