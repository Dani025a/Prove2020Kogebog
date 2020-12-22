package model;

import java.io.Serializable;

public class Recepie implements Serializable {

    IngredientTable ingredientTable = new IngredientTable();
    DescriptionTable descriptionTable = new DescriptionTable();


    String recepieName;
    public int id;
    static int count = 0;

    Recepie(String recepieName){
        this.id = count++;
        this.recepieName = recepieName;
    }

    public void addIngredient(String ingredientName, int ingreientID){ ingredientTable.addIngredient(ingredientName); }

    public void addDescription(String description){descriptionTable.addDescription(description);}

    public IngredientTable getIngredientTable() { return ingredientTable; }

    public DescriptionTable getDescriptionTable() { return descriptionTable; }

    public String getRecepieName() { return recepieName; }




    public int getRecepieId() { return id; }

}
