package View;

import controller.Controller;
import exceptions.NoRecepieException;

import java.util.ArrayList;

public class IngredientTableFX implements Observer {
    ArrayList<IngredientFX> currentRecepieIngredient = new ArrayList<>();


    @Override
    public void Update(Controller controller) throws NoRecepieException {
        currentRecepieIngredient = new ArrayList<>();
        updateRisks(controller);
        if(!(controller.ingredientListView == null)){
            controller.ingredientListView.getItems().clear();
            controller.ingredientListView.getItems().addAll(currentRecepieIngredient);
        }
    }

    private void updateRisks(Controller controller) {
        try {
            controller.getOpenRecepie().getIngredientTable().getIngredients().forEach(ingredient -> currentRecepieIngredient.add(new IngredientFX(ingredient)));
        } catch (Exception e) {
            System.out.println("no current Recepie");
        }
    }
}

