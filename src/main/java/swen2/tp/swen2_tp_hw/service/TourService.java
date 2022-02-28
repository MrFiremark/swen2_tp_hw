package swen2.tp.swen2_tp_hw.service;

import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.repository.TourRepository;

import java.util.HashMap;
import java.util.Map;

public class TourService {

    private final TourRepository tourRepository = new TourRepository();

    private Map<String, Tour> toursMap = new HashMap<>();

    public void addTour(Tour tour){
        toursMap.put(tour.getName(), tour);
    }

    public Map<String, Tour> getToursMap() {
        return toursMap;
    }

    public void updateTourList(){
       this.toursMap = tourRepository.getTours();
    }


}
