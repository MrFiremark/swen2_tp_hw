package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.FXMLDependencyInjection;
import swen2.tp.swen2_tp_hw.listener.SelectedTourLogListener;
import swen2.tp.swen2_tp_hw.model.TourLog;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;

import java.io.IOException;
import java.util.Locale;

public class TableMenuViewModel {

    private final SelectedTourService selectedTourService;

    public TableMenuViewModel(SelectedTourService selectedTourService) {
        this.selectedTourService = selectedTourService;
    }

    public void openAddLogWindow(){
        if(selectedTourService.getSelectedTour() != null){
            try {
                Parent root = FXMLDependencyInjection.load("addLog.fxml", Locale.ENGLISH);
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Add Tour Log");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteTourLog(){
        if(selectedTourService.getSetSelectedTourLog() != null){
            selectedTourService.deleteTourLog();
        }
    }

    public void openEditLogWindow(){
        if(selectedTourService.getSetSelectedTourLog() != null){
            try {
                Parent root = FXMLDependencyInjection.load("editLog.fxml", Locale.ENGLISH);
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Edit Tour Log");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
