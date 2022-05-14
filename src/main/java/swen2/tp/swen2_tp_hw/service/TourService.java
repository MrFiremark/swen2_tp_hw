package swen2.tp.swen2_tp_hw.service;

import swen2.tp.swen2_tp_hw.listener.Listener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.repository.TourRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TourService {

    private final TourRepository tourRepository = new TourRepository();
    private final RouteService routeService = new RouteService();

    private ArrayList<Listener> listeners = new ArrayList<>();

    private Map<String, Tour> toursMap = new HashMap<>();

    public void addListener(Listener tourListener){
        listeners.add(tourListener);
    }

    private void notifyListeners(Tour tour) {
        for ( var listener : listeners ) {
            listener.update(tour);
        }
    }

    public void addTour(Tour tour){
        // TODO validation

        try {
            tour = routeService.getRouteInformation(tour);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        toursMap.put(tour.getid(), tour);
        // TODO Path
        //tourRepository.addTour(tour);
        notifyListeners(tour);
    }

    public void deleteTour(Tour tour){
        //TODO delete
        toursMap.remove(tour.getName());
        tourRepository.deleteTour(tour.getid());
        notifyListeners(tour);
    }

    public Map<String, Tour> getToursMap() {
        return toursMap;
    }

    public Tour getTourFromMap(String tourid){
        return toursMap.get(tourid);
    }

    public void updateTourList(){
       this.toursMap = tourRepository.getTours();
    }


}
