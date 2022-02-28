package swen2.tp.swen2_tp_hw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddLogApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AddTourApplication.class.getResource("addLog.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("Add Tour");
        stage.setScene(scene);
        stage.show();
    }
}
