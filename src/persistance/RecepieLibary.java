package persistance;

import controller.Controller;
import javafx.stage.FileChooser;
import main.Main;
import model.RecepieTable;

import java.io.*;

public class RecepieLibary {

    static FileChooser fileChooser = new FileChooser();

    public static void saveRecepies(Controller controller) {
        try
        {
            FileOutputStream fileOut = new FileOutputStream("src/persistence/Recepies.file");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(controller.getRecepieTable());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void loadRecepies(Controller controller) {
        File projectFile = fileChooser.showOpenDialog(Main.getScene().getWindow());

        FileInputStream file = null;
        try {
            file = new FileInputStream(projectFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            controller.setRecepieTable((RecepieTable) in.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        controller.getOpenRecepie();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

