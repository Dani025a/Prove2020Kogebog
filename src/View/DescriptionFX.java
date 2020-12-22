package View;

import model.Description;
import model.Ingredient;

public class DescriptionFX {
    String description;

    public DescriptionFX(Description description){
        this.description = description.getDescription();
    }
    @Override
    public String toString() {
        return this.description;
    }

}
