package View;

import controller.Controller;
import model.Recepie;

import java.util.ArrayList;

public class RecepieTableFX implements Observer {

    ArrayList<RecepieFX> recepieFXES = new ArrayList<>();
    @Override
    public void Update(Controller controller) {
        ArrayList<Recepie> recepies = controller.getRecepieTable().getRecepies();
        updateRecepies(recepies);
        if(!(controller.listView == null)){
            controller.listView.getItems().clear();
            controller.listView.getItems().addAll(recepieFXES);
        }
    }
    private void updateRecepies(ArrayList<Recepie> recepies) {
        recepieFXES = new ArrayList<>();
        for (Recepie recepie: recepies) {
            recepieFXES.add(new RecepieFX(recepie));
        }
    }
}
