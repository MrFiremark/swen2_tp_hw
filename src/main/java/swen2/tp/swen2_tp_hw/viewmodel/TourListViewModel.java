package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swen2.tp.swen2_tp_hw.listener.TourListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.util.ArrayList;

public class TourListViewModel implements TourListener {

    private ObservableList<Tour> observableTours = FXCollections.observableArrayList();

    private ArrayList<TourListener> tourListeners = new ArrayList<>();

    private final TourService tourService;
    private final SelectedTourService selectedTourService;

    public TourListViewModel(TourService tourService, SelectedTourService selectedTourService){
        this.tourService = tourService;
        this.selectedTourService = selectedTourService;
        if(tourService.getToursMap() != null){
            for (Tour tour: tourService.getToursMap().values()) {
                observableTours.add(tour);
            }
        }
        tourService.addListener(this);
    }

    public ObservableList<Tour> getObservableTours() {
        return observableTours;
    }

    public ChangeListener<Tour> getChangeListener(){
        return (observableValue, oldValue, newValue) -> notifyListeners(newValue);
    }

    public void addListener(TourListener tourLIstener){
        tourListeners.add(tourLIstener);
    }

    private void notifyListeners(Tour tour) {
        for ( var listener : tourListeners) {
            listener.update(tour);
        }
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
        if(index != -1){
            Tour tour = observableTours.get(index);
            selectedTourService.setSelectedTour(tour);
        }
    }
}
