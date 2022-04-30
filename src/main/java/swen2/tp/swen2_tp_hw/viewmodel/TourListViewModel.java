package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swen2.tp.swen2_tp_hw.listener.Listener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.util.ArrayList;
import java.util.List;

public class TourListViewModel implements Listener {
    private ObservableList<Tour> observableTours = FXCollections.observableArrayList();

    private ArrayList<Listener> listeners = new ArrayList<>();

    private final TourService tourService;

    public TourListViewModel(TourService tourService){
        this.tourService = tourService;
        tourService.addListener(this);
    }

    public ObservableList<Tour> getObservableTours() {
        return observableTours;
    }

    public ChangeListener<Tour> getChangeListener(){
        return (observableValue, oldValue, newValue) -> notifyListeners();
    }

    public void addListener(Listener listener){
        listeners.add(listener);
    }

    private void notifyListeners() {
        for ( var listener : listeners ) {
            listener.update();
        }
    }

    public void setTours(List<Tour> tours) {
        observableTours.clear();
        observableTours.addAll(tours);
    }

    public void addNewTour(Tour tour) {
        observableTours.add(tour);
    }

    public void deleteTour(Tour tour) {
        observableTours.remove(tour);
    }

    @Override
    public void update() {
        //TODO Update
        notifyListeners();
    }
}
