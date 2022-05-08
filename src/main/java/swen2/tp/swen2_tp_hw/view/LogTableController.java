package swen2.tp.swen2_tp_hw.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import swen2.tp.swen2_tp_hw.listener.LogListener;
import swen2.tp.swen2_tp_hw.model.TourLog;
import swen2.tp.swen2_tp_hw.viewmodel.LogTableViewModel;

public class LogTableController implements LogListener {

    private final LogTableViewModel logTableViewModel;

    public LogTableController(LogTableViewModel logTableViewModel) {
        this.logTableViewModel = logTableViewModel;
    }

    @FXML
    private TableView<String> tv_logList;

    @FXML
    public void initialize(){
        //tourList_listView.setItems(tourListViewModel.getObservableTours());
        for (TourLog item: logTableViewModel.getObservableLogs()) {
            tv_logList.getItems().add(item.getComment());
        }
        logTableViewModel.addListener(this);
    }

    @Override
    public void update(TourLog log) {
        tv_logList.getItems().clear();
        for (TourLog item: logTableViewModel.getObservableLogs()) {
            tv_logList.getItems().add(item.getComment());
        }
    }
}
