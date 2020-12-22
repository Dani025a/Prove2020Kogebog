package model;

import exceptions.NoRecepieException;

import java.io.Serializable;
import java.util.ArrayList;

public class IngredientTable implements Serializable {

    ArrayList<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(String ingredientName) { getIngredients().add(new Ingredient(ingredientName));
    }

    public void deleteIngredient(int ingredientID) throws NoRecepieException {
        getIngredients().remove(getIngredient(ingredientID));
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public Ingredient getIngredient(int ingredientID) throws NoRecepieException {

        for (Ingredient ingredient : getIngredients()) {
            if (ingredient.getId() == ingredientID) {
                return ingredient;
            }
        }
        throw new NoRecepieException("Ingredient was not found!");
    }
}
