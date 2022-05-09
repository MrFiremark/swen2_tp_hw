package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swen2.tp.swen2_tp_hw.listener.Listener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.util.ArrayList;
import java.util.List;

public class TourListViewModel implements Listener {

    private ObservableList<Tour> observableTours = FXCollections.observableArrayList();

    private ArrayList<Listener> listeners = new ArrayList<>();

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

    public void addListener(Listener tourLIstener){
        listeners.add(tourLIstener);
    }

    private void notifyListeners(Tour tour) {
        for ( var listener : listeners ) {
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
