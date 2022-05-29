package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.FXMLDependencyInjection;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;
import swen2.tp.swen2_tp_hw.view.AddTourController;
import swen2.tp.swen2_tp_hw.wrapper.ILoggerWrapper;
import swen2.tp.swen2_tp_hw.wrapper.LoggerFactory;

import java.io.IOException;
import java.util.Locale;

public class ListMenuViewModel{

    private ILoggerWrapper logger = LoggerFactory.getLogger();
    private final TourService tourService;
    private final SelectedTourService selectedTourService;


    public ListMenuViewModel(TourService tourService, SelectedTourService selectedTourService) {
        this.tourService = tourService;
        this.selectedTourService = selectedTourService;
    }

    public void openAddTourWindow(){
        try {
            Parent root = FXMLDependencyInjection.load("addTour.fxml", Locale.ENGLISH);
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
        if(selectedTourService.getSelectedTour() != null){
            tourService.deleteTour(selectedTourService.getSelectedTour());
            selectedTourService.setSelectedTour(null);
        }else{
            logger.warn("Delete tour error[201]. No tour selected.");
            createErrorDialog("Error deleting tour!", "No tour selected!");
        }
    }

    public void openEditTourWindow(){
        if(selectedTourService.getSelectedTour() != null){
            try {
                Parent root = FXMLDependencyInjection.load("editTour.fxml", Locale.ENGLISH);
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Edit Tour");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            logger.warn("Edit tour error[202]. No tour selected.");
            createErrorDialog("Error editing tour!", "No tour selected!");
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
