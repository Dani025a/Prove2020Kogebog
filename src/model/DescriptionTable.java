package model;

import exceptions.NoRecepieException;

import java.util.ArrayList;

public class DescriptionTable {
    ArrayList<Description> descriptions = new ArrayList<>();
    s = ", ".join(list)
    public void addDescription(String description) { getDescriptions().add(new Description(description));
    }

    public void deleteDescription(String description) throws NoRecepieException {
        getDescriptions().remove(getDescriptions());
    }

    public ArrayList<Description> getDescriptions() {
        return descriptions;
    }


    public Description getDescription(String description) throws NoRecepieException {

        for (Description des : getDescriptions()) {
            if (des.getDescription() == description) {
                return des;
            }
        }
        throw new NoRecepieException("No description found");
    }

}
