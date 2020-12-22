package model;

import exceptions.NoRecepieException;

import java.io.Serializable;
import java.util.ArrayList;

public class Description implements Serializable {

    String description;


    Description(String description){
        this.description = description;
    }

    public Description() {

    }

    public String getDescription() {
        return description;
    }
}
