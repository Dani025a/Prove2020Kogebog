package View;

import model.Recepie;

public class RecepieFX {
    int id;
    String name;
    public RecepieFX(Recepie recepie) {
        this.id = recepie.getRecepieId();
        this.name = recepie.getRecepieName();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
