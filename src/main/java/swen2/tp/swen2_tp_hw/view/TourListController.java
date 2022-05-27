package swen2.tp.swen2_tp_hw.view;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import swen2.tp.swen2_tp_hw.listener.TourListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.viewmodel.TourListViewModel;
import swen2.tp.swen2_tp_hw.wrapper.ILoggerWrapper;
import swen2.tp.swen2_tp_hw.wrapper.LoggerFactory;

public class TourListController {

    private final TourListViewModel tourListViewModel;
    private static ILoggerWrapper logger = LoggerFactory.getLogger();
    public TourListController(TourListViewModel tourListViewModel) {
        this.tourListViewModel = tourListViewModel;
    }

    @FXML
    private ListView<String> tourList_listView;

    @FXML
    public void initialize(){
        tourList_listView.itemsProperty().bindBidirectional(tourListViewModel.getTourNameData());
    }

    @FXML
    public void itemClicked(){
        int index = tourList_listView.getSelectionModel().getSelectedIndex();
        tourListViewModel.itemClicked(index);
        logger.debug("Debug message");
        System.out.println(logger);
    }
}
