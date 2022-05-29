package swen2.tp.swen2_tp_hw.service;

import swen2.tp.swen2_tp_hw.listener.TourListener;
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
    private final AttributeService attributeService = new AttributeService();

    private ArrayList<TourListener> tourListeners = new ArrayList<>();

    private Map<String, Tour> toursMap = new HashMap<>();

    public void addListener(TourListener tourListener){
        tourListeners.add(tourListener);
    }

    private void notifyListeners() {
        for ( var listener : tourListeners) {
            listener.update();
        }
    }

    public void addTour(Tour tour){
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
        tourRepository.addTour(tour);
        notifyListeners();
    }

    public void deleteTour(Tour tour){
        toursMap.remove(tour.getid());
        tourRepository.deleteTour(tour.getid());

        notifyListeners();
    }

    public void editTour(Tour tour){
        try {
            tour = routeService.getRouteInformation(tour);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tourRepository.updateTour(tour);
        notifyListeners();
    }

    public void loadTours(){
        this.toursMap = tourRepository.getTours();
        // TODO correct error handling
        if(toursMap == null){
            toursMap = new HashMap<>();
        }
        for (Tour temp: toursMap.values()
             ) {
            if (temp.getTourLogs().size() != 0) {
                temp.setChildFriendliness(attributeService.setChildFriendliness(temp));
            }
        }
    }

    public Map<String, Tour> getToursMap() {
        return toursMap;
    }

    public Tour getTourFromMap(String tourid){
        return toursMap.get(tourid);
    }

    public void updateTourList(){
       this.toursMap = tourRepository.getTours();
       if(toursMap == null){
           toursMap = new HashMap<>();
       }
    }
}
