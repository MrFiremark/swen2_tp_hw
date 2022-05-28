package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.*;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.util.UUID;

public class AddTourViewModel {

    private final StringProperty tourName = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final StringProperty from = new SimpleStringProperty();
    private final StringProperty to = new SimpleStringProperty();
    private final ObjectProperty<String> transportType = new SimpleObjectProperty<>();
    private final BooleanProperty addButton = new SimpleBooleanProperty();

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
    public ObjectProperty<String> getTransportType() {
        return transportType;
    }
    public BooleanProperty getAddButton(){
        return addButton;
    }

    public void saveTour(){
        Tour tour = new Tour(UUID.randomUUID().toString() ,tourName.get(), description.get(), from.get(), to.get(), transportType.get());
        resetValues();
        tourService.addTour(tour);
    }

    private void resetValues(){
        tourName.set("");
        description.set("");
        from.set("");
        to.set("");
        transportType.set("");
    }


}
