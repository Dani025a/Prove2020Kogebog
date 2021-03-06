package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Scene scene;
    private static final FileChooser fileChooser = new FileChooser();

    public static Scene getScene() {
        return scene;
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(), 1134, 678);
        stage.setScene(scene);
        stage.setTitle("Recepie book");
        stage.show();
    }

    private static Parent loadFXML() throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("../view/MainPage.fxml"));
    return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
