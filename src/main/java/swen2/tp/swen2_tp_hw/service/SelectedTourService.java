package swen2.tp.swen2_tp_hw.service;

import swen2.tp.swen2_tp_hw.listener.SelectedTourListener;
import swen2.tp.swen2_tp_hw.listener.TourLogListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;
import swen2.tp.swen2_tp_hw.repository.LogRepository;

import java.util.ArrayList;

public class SelectedTourService {

    private Tour selectedTour;
    private TourLog selectedTourLog;
    private final LogRepository logRepository = new LogRepository();

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

    public TourLog getSetSelectedTourLog(){
        return selectedTourLog;
    }

    public void setSelectedTour(Tour tour){
        this.selectedTour = tour;
        notifyListeners(tour);
    }

    public void setSetSelectedTourLog(TourLog tourLog){
        this.selectedTourLog = tourLog;
    }

    public void addTourLog(TourLog tourLog){
        selectedTour.addTourLog(tourLog);
        logRepository.addTourLog(tourLog);
        notifyListeners(selectedTour);
    }

    public void editTourLog(){
        logRepository.updateTourLog(selectedTourLog);
        notifyListeners(selectedTour);
    }

    public void deleteTourLog(){
        //TODO validation
        if(selectedTourLog != null){
            selectedTour.deleteTourLog(selectedTourLog);
            logRepository.deleteTourLog(selectedTourLog.getLogid());
            notifyListeners(selectedTour);
        }
    }
}
