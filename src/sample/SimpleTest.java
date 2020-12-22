package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SimpleTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Velkommen til min opskrifts-applikations-dummy");
        blankLine();
        blankLine();
        System.out.println("Velkommen til min opskrifts-applikations-dummy");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void blankLine(){
        System.out.println("\n");
    }
}
