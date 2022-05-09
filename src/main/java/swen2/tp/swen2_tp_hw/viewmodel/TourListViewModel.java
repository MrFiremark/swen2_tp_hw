package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swen2.tp.swen2_tp_hw.listener.Listener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.SelectedItemService;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.util.ArrayList;
import java.util.List;

public class TourListViewModel implements Listener {

    private ObservableList<Tour> observableTours = FXCollections.observableArrayList();

    private ArrayList<Listener> listeners = new ArrayList<>();

    private final TourService tourService;
    private final SelectedItemService selectedItemService;

    public TourListViewModel(TourService tourService, SelectedItemService selectedItemService){
        this.tourService = tourService;
        this.selectedItemService = selectedItemService;
        tourService.addListener(this);
    }

    public ObservableList<Tour> getObservableTours() {
        return observableTours;
    }

    public ChangeListener<Tour> getChangeListener(){
        return (observableValue, oldValue, newValue) -> notifyListeners(newValue);
    }

    public void addListener(Listener tourLIstener){
        listeners.add(tourLIstener);
    }

    private void notifyListeners(Tour tour) {
        for ( var listener : listeners ) {
            listener.update(tour);
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
    public void update(Tour tour) {
        observableTours.add(tour);
        notifyListeners(tour);
    }

    public void itemClicked(int index){
        Tour tour = observableTours.get(index);
        selectedItemService.setSelectedTour(tour);
    }
}
