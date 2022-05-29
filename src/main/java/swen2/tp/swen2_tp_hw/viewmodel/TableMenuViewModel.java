package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.FXMLDependencyInjection;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.wrapper.ILoggerWrapper;
import swen2.tp.swen2_tp_hw.wrapper.LoggerFactory;

import java.io.IOException;
import java.util.Locale;

public class TableMenuViewModel {

    private ILoggerWrapper logger = LoggerFactory.getLogger();
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
        if(selectedTourService.getSelectedTourLog() != null){
            selectedTourService.deleteTourLog();
        }else{
            logger.warn("Delete tour log error[301]. No tour log selected.");
            createErrorDialog("Error deleting tour log!", "No tour log selected!");
        }
    }

    public void openEditLogWindow(){
        if(selectedTourService.getSelectedTourLog() != null){
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
        }else{
            logger.warn("Edit tour log error[302]. no tour log selected.");
            createErrorDialog("Error editing tour log!", "No tour log selected!");
        }
    }

    private void createErrorDialog(String header, String content){
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText(header);
        dialog.setContentText(content);
        dialog.showAndWait();
    }
}
