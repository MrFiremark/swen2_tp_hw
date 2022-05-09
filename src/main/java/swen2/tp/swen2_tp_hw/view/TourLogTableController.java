package swen2.tp.swen2_tp_hw.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import swen2.tp.swen2_tp_hw.listener.TourLogListener;
import swen2.tp.swen2_tp_hw.model.TourLog;
import swen2.tp.swen2_tp_hw.viewmodel.TourLogTableViewModel;

public class TourLogTableController implements TourLogListener {

    private final TourLogTableViewModel logTableViewModel;

    public TourLogTableController(TourLogTableViewModel logTableViewModel) {
        this.logTableViewModel = logTableViewModel;
    }

    @FXML
    private TableView tv_logList;
    @FXML
    private TableColumn tbc_date;
    @FXML
    private TableColumn tbc_comment;
    @FXML
    private TableColumn tbc_difficulty;
    @FXML
    private TableColumn tbc_totalTime;
    @FXML
    private TableColumn tbc_rating;

    @FXML
    public void initialize(){
        //tourList_listView.setItems(tourListViewModel.getObservableTours());
        tbc_date.setCellValueFactory(new PropertyValueFactory<TourLog, String>("date"));
        for (TourLog item: logTableViewModel.getObservableLogs()) {
            tv_logList.getItems().add(item);
        }
        logTableViewModel.addListener(this);
    }

    @Override
    public void update() {
        tv_logList.getItems().clear();
        for (TourLog item: logTableViewModel.getObservableLogs()) {
            tv_logList.getItems().add(item);
        }
    }
}
