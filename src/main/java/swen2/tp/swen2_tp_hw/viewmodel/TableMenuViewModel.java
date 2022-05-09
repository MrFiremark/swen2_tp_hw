package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.FXMLDependencyInjection;

import java.io.IOException;
import java.util.Locale;

public class TableMenuViewModel {

    public void openAddTourWindow(){
        try {
            Parent root = FXMLDependencyInjection.load("addLog.fxml", Locale.ENGLISH);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Add Tour");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteTour(){

    }

}
