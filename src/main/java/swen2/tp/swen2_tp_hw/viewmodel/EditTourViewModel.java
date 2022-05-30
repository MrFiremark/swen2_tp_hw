package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.*;
import swen2.tp.swen2_tp_hw.listener.SelectedTourListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;

public class EditTourViewModel implements SelectedTourListener {
    private final StringProperty tourName = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final StringProperty from = new SimpleStringProperty();
    private final StringProperty to = new SimpleStringProperty();
    private final ObjectProperty<String> transportType = new SimpleObjectProperty<>();
    private final BooleanProperty enabled = new SimpleBooleanProperty();

    private final TourService tourService;
    private final SelectedTourService selectedTourService;

    public EditTourViewModel(TourService tourService, SelectedTourService selectedTourService){
        this.tourService = tourService;
        this.selectedTourService = selectedTourService;
        enabled.bind(tourName.isEmpty()
                .or(description.isEmpty())
                .or(from.isEmpty())
                .or(to.isEmpty())
                .or(transportType.isNull()));
        selectedTourService.addListener(this);
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
    public BooleanProperty getEnabled(){
        return enabled;
    }

    public void editTour(){
        selectedTourService.getSelectedTour().setName(tourName.get());
        selectedTourService.getSelectedTour().setDescription(description.get());
        selectedTourService.getSelectedTour().setFrom(from.get());
        selectedTourService.getSelectedTour().setTo(to.get());
        selectedTourService.getSelectedTour().setTransportType(transportType.get());
        tourService.editTour(selectedTourService.getSelectedTour());
    }


    @Override
    public void update(Tour tour) {
        if (tour != null) {
            tourName.set(tour.getName());
            description.set(tour.getDescription());
            from.set(tour.getFrom());
            to.set(tour.getTo());
            transportType.set(tour.getTransportType());
        }
    }

    private void resetValues(){
        tourName.set("");
        description.set("");
        from.set("");
        to.set("");
        transportType.set("");
    }
}
