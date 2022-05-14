package swen2.tp.swen2_tp_hw.view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import swen2.tp.swen2_tp_hw.listener.Listener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.viewmodel.TourListViewModel;

public class TourListController implements Listener {

    private final TourListViewModel tourListViewModel;

    public TourListController(TourListViewModel tourListViewModel) {
        this.tourListViewModel = tourListViewModel;
    }

    @FXML
    private ListView<String> tourList_listView;

    @FXML
    public void initialize(){
        //tourList_listView.setItems(tourListViewModel.getObservableTours());
        for (Tour item: tourListViewModel.getObservableTours()) {
            tourList_listView.getItems().add(item.getName());
        }
        tourListViewModel.addListener(this);
    }

    @Override
    public void update(Tour tour) {
        tourList_listView.getItems().clear();
        for (Tour item: tourListViewModel.getObservableTours()) {
            tourList_listView.getItems().add(item.getName());
        }
    }

    public void itemClicked(){
        int index = tourList_listView.getSelectionModel().getSelectedIndex();
        tourListViewModel.itemClicked(index);
    }

}
