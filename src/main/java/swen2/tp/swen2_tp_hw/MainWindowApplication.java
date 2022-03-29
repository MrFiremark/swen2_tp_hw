package swen2.tp.swen2_tp_hw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class MainWindowApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLDependencyInjection.load("home.fxml", Locale.ENGLISH );

        Scene scene = new Scene(root);

        stage.setTitle("Tour Planner");
        stage.setScene(scene);
        stage.show();
    }

}