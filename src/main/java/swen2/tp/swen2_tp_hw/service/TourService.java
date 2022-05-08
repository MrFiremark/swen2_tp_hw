package swen2.tp.swen2_tp_hw.service;

import swen2.tp.swen2_tp_hw.listener.TourListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.repository.TourRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TourService {

    private final TourRepository tourRepository = new TourRepository();

    private ArrayList<TourListener> listeners = new ArrayList<>();

    private Map<String, Tour> toursMap = new HashMap<>();

    public void addListener(TourListener tourListener){
        listeners.add(tourListener);
    }

    private void notifyListeners(Tour tour) {
        for ( var listener : listeners ) {
            listener.update(tour);
        }
    }

    public void addTour(Tour tour){
        // TODO validation
        toursMap.put(tour.getName(), tour);
        tourRepository.addTour(tour);
        notifyListeners(tour);
    }

    public void deleteTour(Tour tour){
        //TODO delete
        toursMap.remove(tour);
        tourRepository.deleteTour(tour.getid());
        notifyListeners(tour);
    }

    public Map<String, Tour> getToursMap() {
        return toursMap;
    }

    public void updateTourList(){
       this.toursMap = tourRepository.getTours();
    }


}
