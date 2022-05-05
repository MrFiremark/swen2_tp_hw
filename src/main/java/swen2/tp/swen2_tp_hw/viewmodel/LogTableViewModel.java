package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swen2.tp.swen2_tp_hw.listener.Listener;
import swen2.tp.swen2_tp_hw.listener.LogListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;
import swen2.tp.swen2_tp_hw.service.LogService;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.util.ArrayList;
import java.util.List;

public class LogTableViewModel implements LogListener {

    private ObservableList<TourLog> observableLogs = FXCollections.observableArrayList();

    private ArrayList<LogListener> listeners = new ArrayList<>();

    private final LogService logService;

    public LogTableViewModel(LogService logService){
        this.logService = logService;
        logService.addListener(this);
    }

    public ObservableList<TourLog> getObservableLogs() {
        return observableLogs;
    }

    public ChangeListener<TourLog> getChangeListener(){
        return (observableValue, oldValue, newValue) -> notifyListeners(newValue);
    }

    public void addListener(LogListener logListener){
        listeners.add(logListener);
    }

    private void notifyListeners(TourLog log) {
        for ( var listener : listeners ) {
            listener.update(log);
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
    public void update(TourLog log) {
        observableLogs.add(log);
        notifyListeners(log);
    }
}
