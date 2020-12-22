package View;

import controller.Controller;
import exceptions.NoRecepieException;

import java.util.ArrayList;

public class DescriptionTableFX implements Observer{
    ArrayList<DescriptionFX> currentRecepieDescription = new ArrayList<>();


    @Override
    public void Update(Controller controller) throws NoRecepieException {
        currentRecepieDescription = new ArrayList<>();
        updateDes(controller);
        if(!(controller.descriptionText == null)){
            controller.descriptionText.clear();
            controller.descriptionText.setText(String.valueOf(currentRecepieDescription));
        }
    }

    private void updateDes(Controller controller) {
        try {
            controller.getOpenRecepie().getDescriptionTable().getDescriptions().forEach(des -> currentRecepieDescription.add(new DescriptionFX(des)));
        } catch (Exception e) {
            System.out.println("no current Recepie");
        }
    }
}
