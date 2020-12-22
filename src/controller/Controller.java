package controller;

import View.*;
import exceptions.NoIngredientException;
import exceptions.NoRecepieException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.Recepie;
import model.RecepieTable;
import persistance.RecepieLibary;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public ListView<RecepieFX> listView = new ListView<>();

    @FXML
    public TextArea descriptionText;

    @FXML
    private ImageView imageBox;

    @FXML
    public ListView<IngredientFX> ingredientListView = new ListView<>();

    @FXML
    private Label recepieLabel;

    @FXML
    private TextField recepieNameTextField;

    @FXML
    private TextField ingredientNameTextField;


    Recepie openRecepie;
    RecepieFX selectedRecepie;
    IngredientFX selectedIngredient;
    int RecepieID;
    int ingredientID;
    int description;

    RecepieTable recepieTable = new RecepieTable();
    RecepieTableFX recepieTableFX = new RecepieTableFX();
    IngredientTableFX ingredientTableFX = new IngredientTableFX();
    DescriptionTableFX descriptionTableFX = new DescriptionTableFX();




    public void saveRecepie(){
        RecepieLibary.saveRecepies(this);}


    public void loadRecepies() throws NoRecepieException {
        this.recepieTable = null;

        RecepieLibary.loadRecepies(this);
        this.listView.getItems().clear();
        this.ingredientListView.getItems().clear();

        ArrayList<Recepie> recepies = getRecepieTable().getRecepies();
        for (Recepie recepie : recepies) {
            listView.getItems().add(new RecepieFX(recepie));
        }
        this.openRecepie = getRecepieTable().getRecepies().get(0);
        this.ingredientTableFX.Update(this);
    }


    public void addRecepie(String name) throws NoRecepieException {
        recepieTable.addRecepie(name);
        recepieTableFX.Update(this);
    }


    public void onActionAddRecepie(){
        try {
            addRecepie(recepieNameTextField.getText());
            if(this.openRecepie == null) {
                this.openRecepie = getRecepieTable().getRecepies().get(0);
            }
        } catch (NoRecepieException noRecepieException) {
            noRecepieException.printStackTrace();
        }
    }

    public void addIngredient(String name) throws NoRecepieException, NoIngredientException {
        this.openRecepie.addIngredient(name,ingredientID);
        this.ingredientTableFX.Update(this);
    }

    public void onActionAddIngredient(){
        try {
            addIngredient(ingredientNameTextField.getText());
        } catch (NoRecepieException noRecepieException) {
            noRecepieException.printStackTrace();
        } catch (NoIngredientException e) {
            e.printStackTrace();
        }
    }

    public void addDescription(String description) throws NoRecepieException{
        this.openRecepie.addDescription(description);
        this.descriptionTableFX.Update(this);
    }

    public void onActionAddDescription(){
        try {
            addDescription(descriptionText.getText());
        } catch (NoRecepieException noRecepieException) {
            noRecepieException.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<RecepieFX> recepieFXES = new ArrayList<>();
        if (getRecepieTable() == null) return;
        getRecepieTable().getRecepies().forEach(r -> recepieFXES.add(new RecepieFX(r)));
        listView.getItems().addAll(recepieFXES);
    }

//Recepie
    public RecepieTable getRecepieTable() {
        return recepieTable;
    }

    public void setRecepieTable(RecepieTable recepieTable) {
        this.recepieTable = recepieTable;
    }

    @FXML
    public void setOpenRecepie() throws NoRecepieException {
        RecepieFX selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) return;
        try {
            this.openRecepie = recepieTable.getRecepie(selectedItem.getId());
            this.recepieLabel.setText(selectedItem.toString());

        } catch (Exception e) {
            System.out.println("No recepie");
        }
        this.recepieTableFX.Update(this);
        this.ingredientTableFX.Update(this);
        this.descriptionTableFX.Update(this);
    }

    public Recepie getOpenRecepie() {
        return openRecepie;
    }
}
