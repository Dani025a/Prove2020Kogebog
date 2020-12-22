package model;

import exceptions.NoRecepieException;

import java.io.Serializable;
import java.util.ArrayList;

public class RecepieTable implements Serializable {
    ArrayList<Recepie> recepies = new ArrayList<>();


    public void addRecepie(String recepieName) {
        getRecepies().add(new Recepie(recepieName));
    }

    public void deleteRecepie(int recepieID) throws NoRecepieException {
        getRecepies().remove(getRecepie(recepieID));
    }

    public ArrayList<Recepie> getRecepies() {

        return recepies;
    }


    public Recepie getRecepie(int recepieID) throws NoRecepieException {

        for (Recepie recepie : getRecepies()) {
            if (recepie.getRecepieId() == recepieID) {
                return recepie;
            }
        }
        throw new NoRecepieException("Recepie was not found!");
    }
}
