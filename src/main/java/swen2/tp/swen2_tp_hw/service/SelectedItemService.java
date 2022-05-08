package swen2.tp.swen2_tp_hw.service;

import swen2.tp.swen2_tp_hw.listener.SelectedItemListener;
import swen2.tp.swen2_tp_hw.model.Tour;

import java.util.ArrayList;

public class SelectedItemService {

    private Tour selectedTour;

    private ArrayList<SelectedItemListener> listeners = new ArrayList<>();

    public void addListener(SelectedItemListener listener){
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

}
