package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swen2.tp.swen2_tp_hw.listener.SelectedTourListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;

import java.util.ArrayList;
import java.util.List;

public class TourLogTableViewModel implements SelectedTourListener {

    private ObservableList<TourLog> observableLogs = FXCollections.observableArrayList();
    private ObjectProperty<ObservableList<TourLog>> logData = new SimpleObjectProperty<>();

    private final SelectedTourService selectedTourService;

    public TourLogTableViewModel(SelectedTourService selectedTourService){
        this.selectedTourService = selectedTourService;
        selectedTourService.addListener(this);
    }

    public ObjectProperty<ObservableList<TourLog>> getLogData() { return logData; }


    public void setLogs(List<TourLog> logs) {
        observableLogs.clear();
        observableLogs.addAll(logs);
    }

    @Override
    public void update(Tour tour) {
        observableLogs.clear();
        if (tour != null) {
            observableLogs.addAll(tour.getTourLogs());
        }
        logData.set(observableLogs);
    }

    public void itemClicked(int index){
        if(index != -1){
            TourLog tourLog = observableLogs.get(index);
            selectedTourService.setSetSelectedTourLog(tourLog);
        }
    }
}
