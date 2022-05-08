package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.util.UUID;

public class AddTourViewModel {

    private final StringProperty tourName = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final StringProperty from = new SimpleStringProperty();
    private final StringProperty to = new SimpleStringProperty();
    private final StringProperty transportType = new SimpleStringProperty();

    private final TourService tourService;

    public AddTourViewModel(TourService tourService){
        this.tourService = tourService;
    }
    public StringProperty getTourName() {
        return tourName;
    }

    public StringProperty getDescription() {
        return description;
    }

    public StringProperty getFrom() {
        return from;
    }

    public StringProperty getTo() {
        return to;
    }

    public StringProperty getTransportType() {
        return transportType;
    }

    public void saveTour(){
        Tour tour = new Tour(UUID.randomUUID().toString() ,tourName.get(), description.get(), to.get(), from.get(), "Bike");
        tourService.addTour(tour);
    }

    public void closeWindow(){

    }
}
