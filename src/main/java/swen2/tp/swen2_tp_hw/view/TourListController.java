package swen2.tp.swen2_tp_hw.view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.viewmodel.TourListViewModel;

public class TourListController {

    private final TourListViewModel tourListViewModel;

    public TourListController(TourListViewModel tourListViewModel) {
        this.tourListViewModel = tourListViewModel;
    }

    @FXML
    private ListView<Tour> tourList_listView;

    @FXML
    public void initialize(){
        tourList_listView.setItems(tourListViewModel.getObservableTours());
        tourList_listView.getSelectionModel().selectedItemProperty().addListener(tourListViewModel.getChangeListener());
    }
}