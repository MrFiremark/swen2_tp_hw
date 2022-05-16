package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.FXMLDependencyInjection;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;
import swen2.tp.swen2_tp_hw.view.AddTourController;

import java.io.IOException;
import java.util.Locale;

public class ListMenuViewModel{

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
        }
    }
    public void openEditTourWindow(){
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
    }
}
