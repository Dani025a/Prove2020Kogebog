package model;

import java.io.Serializable;

public class Recepie implements Serializable {

    IngredientTable ingredientTable = new IngredientTable();

    String recepieName;
    public int id;
    static int count = 0;

    Recepie(String recepieName){
        this.id = count++;
        this.recepieName = recepieName;
    }

    public void addIngredient(String ingredientName, int ingreientID){
        ingredientTable.addIngredient(ingredientName);
    }


    public IngredientTable getIngredientTable() { return ingredientTable; }

    public String getRecepieName() { return recepieName; }




    public int getRecepieId() { return id; }

}
