package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.AddTourApplication;
import swen2.tp.swen2_tp_hw.FXMLDependencyInjection;
import swen2.tp.swen2_tp_hw.listener.SelectedItemListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.SelectedItemService;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.io.IOException;
import java.util.Locale;

public class ListMenuViewModel{

    private final TourService tourService;
    private final SelectedItemService selectedItemService;

    public ListMenuViewModel(TourService tourService, SelectedItemService selectedItemService) {
        this.tourService = tourService;
        this.selectedItemService = selectedItemService;
    }

    public void openAddTourWindow(){
        try {
            Parent root = FXMLDependencyInjection.load("addTour.fxml", Locale.ENGLISH);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Tour Planner");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteTour(){
        if(selectedItemService.getSelectedTour() != null){
            tourService.deleteTour(selectedItemService.getSelectedTour());
            selectedItemService.setSelectedTour(null);
        }
    }

}
