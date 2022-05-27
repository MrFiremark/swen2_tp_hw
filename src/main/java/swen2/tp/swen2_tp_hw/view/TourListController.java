package swen2.tp.swen2_tp_hw.view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import swen2.tp.swen2_tp_hw.viewmodel.TourListViewModel;
import swen2.tp.swen2_tp_hw.wrapper.ILoggerWrapper;
import swen2.tp.swen2_tp_hw.wrapper.LoggerFactory;

public class TourListController {

    private final TourListViewModel tourListViewModel;
    public TourListController(TourListViewModel tourListViewModel) {
        this.tourListViewModel = tourListViewModel;
    }

    @FXML
    private ListView<String> lv_tourList;

    @FXML
    public void initialize(){
        lv_tourList.itemsProperty().bindBidirectional(tourListViewModel.getTourNameData());
    }

    @FXML
    public void itemClicked(){
        int index = lv_tourList.getSelectionModel().getSelectedIndex();
        tourListViewModel.itemClicked(index);
    }
}
