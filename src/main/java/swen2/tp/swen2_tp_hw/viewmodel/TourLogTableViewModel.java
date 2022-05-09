package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swen2.tp.swen2_tp_hw.listener.SelectedTourListener;
import swen2.tp.swen2_tp_hw.listener.TourLogListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;

import java.util.ArrayList;
import java.util.List;

public class TourLogTableViewModel implements SelectedTourListener {

    private ObservableList<TourLog> observableLogs = FXCollections.observableArrayList();

    private ArrayList<TourLogListener> listeners = new ArrayList<>();

    private final SelectedTourService selectedTourService;

    public TourLogTableViewModel(SelectedTourService selectedTourService){
        this.selectedTourService = selectedTourService;
        selectedTourService.addListener(this);
    }

    public ObservableList<TourLog> getObservableLogs() {
        return observableLogs;
    }


    public void addListener(TourLogListener tourLogListener){
        listeners.add(tourLogListener);
    }

    private void notifyListeners() {
        for ( var listener : listeners ) {
            listener.update();
        }
    }

    public void setLogs(List<TourLog> logs) {
        observableLogs.clear();
        observableLogs.addAll(logs);
    }

    public void addNewTour(TourLog log) {
        observableLogs.add(log);
    }

    public void deleteTour(TourLog log) {
        observableLogs.remove(log);
    }

    @Override
    public void update(Tour tour) {
        for (TourLog log: tour.getTourLogs()) {
            observableLogs.add(log);
        }
        notifyListeners();
    }
}
