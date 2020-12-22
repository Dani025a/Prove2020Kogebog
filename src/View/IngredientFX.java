package View;

import model.Ingredient;

public class IngredientFX {
    int id;
    String name;

public IngredientFX(Ingredient ingredient){

this.id = ingredient.getId();
this.name = ingredient.getIngredientName();
}
    @Override
    public String toString() {
        return this.name;
}

}
