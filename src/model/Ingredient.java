package model;

import java.io.Serializable;

public class Ingredient implements Serializable {

    String ingredientName;
    public int Id;
    int count = 0;


    Ingredient(String ingredientName){
        this.Id = count++;
        this.ingredientName = ingredientName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getId() {
        return this.Id;
    }

}
