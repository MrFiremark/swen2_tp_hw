package swen2.tp.swen2_tp_hw.service;

import swen2.tp.swen2_tp_hw.listener.SelectedTourListener;
import swen2.tp.swen2_tp_hw.listener.TourLogListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;

import java.util.ArrayList;

public class SelectedTourService {

    private Tour selectedTour;

    private ArrayList<SelectedTourListener> listeners = new ArrayList<>();

    private ArrayList<TourLogListener> tourLogListeners = new ArrayList<>();

    public void addListener(SelectedTourListener listener){
        listeners.add(listener);
    }

    public void notifyListeners(Tour tour) {
        for ( var listener : listeners ) {
            listener.update(tour);
        }
    }

    public Tour getSelectedTour() {
        return selectedTour;
    }

    public void setSelectedTour(Tour tour){
        this.selectedTour = tour;
        notifyListeners(tour);
    }

    public void addTourLog(TourLog tourLog){
        selectedTour.addTourLog(tourLog);
        notifyListeners(selectedTour);
    }

}
