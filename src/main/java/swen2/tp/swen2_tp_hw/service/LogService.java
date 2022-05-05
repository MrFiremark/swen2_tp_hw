package swen2.tp.swen2_tp_hw.service;

import swen2.tp.swen2_tp_hw.listener.Listener;
import swen2.tp.swen2_tp_hw.listener.LogListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;

import java.util.ArrayList;

public class LogService {

    private ArrayList<LogListener> listeners = new ArrayList<>();

    ArrayList<TourLog> tourLogs = new ArrayList<>();

    public void addListener(LogListener logListener){
        listeners.add(logListener);
    }

    private void notifyListeners(TourLog log) {
        for ( var listener : listeners ) {
            listener.update(log);
        }
    }

    public void addTourLog(TourLog log){
        tourLogs.add(log);
        notifyListeners(log);
    }
}
