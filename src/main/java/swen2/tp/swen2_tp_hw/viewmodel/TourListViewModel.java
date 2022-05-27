package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MultipleSelectionModel;
import swen2.tp.swen2_tp_hw.listener.TourListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.util.ArrayList;

public class TourListViewModel implements TourListener {

    private ObservableList<Tour> observableTours = FXCollections.observableArrayList();
    private ObservableList<String> tourNames = FXCollections.observableArrayList();
    private final ObjectProperty<ObservableList<String>> tourNameData = new SimpleObjectProperty<>();

    private ArrayList<TourListener> tourListeners = new ArrayList<>();

    private final TourService tourService;
    private final SelectedTourService selectedTourService;

    public TourListViewModel(TourService tourService, SelectedTourService selectedTourService){
        this.tourService = tourService;
        this.selectedTourService = selectedTourService;
        tourService.loadTours();
        if(tourService.getToursMap() != null){
            observableTours.addAll(tourService.getToursMap().values());
            for (Tour tour: tourService.getToursMap().values()
                 ) {
                tourNames.add(tour.getName());
            }
            tourNameData.set(tourNames);
        }
        tourService.addListener(this);
    }

    public ObservableList<Tour> getObservableTours() {
        return observableTours;
    }
    public ObjectProperty<ObservableList<String>> getTourNameData() { return tourNameData; }

    public void addListener(TourListener tourLIstener){
        tourListeners.add(tourLIstener);
    }

    private void notifyListeners() {
        for ( var listener : tourListeners) {
            listener.update();
        }
    }

    public void deleteTour(Tour tour) {
        observableTours.remove(tour);
    }

    @Override
    public void update() {
        observableTours.clear();
        tourNames.clear();
        for (Tour tour: tourService.getToursMap().values()) {
            observableTours.add(tour);
            tourNames.add(tour.getName());
        }
        tourNameData.set(tourNames);
        notifyListeners();
    }

    public void itemClicked(int index){
        if(index != -1){
            Tour tour = observableTours.get(index);
            selectedTourService.setSelectedTour(tour);
        }
        System.out.println(index);
    }

    // TODO maybe update Listener
}
