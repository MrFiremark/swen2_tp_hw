package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.*;
import javafx.scene.image.Image;
import swen2.tp.swen2_tp_hw.listener.SelectedTourListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;

import java.awt.*;
import java.io.File;


public class TabPaneViewModel implements SelectedTourListener {

    private final SelectedTourService selectedTourService;

    private final StringProperty tourName = new SimpleStringProperty();
    private final StringProperty from = new SimpleStringProperty();
    private final StringProperty to = new SimpleStringProperty();
    private final StringProperty transportType = new SimpleStringProperty();
    private final StringProperty distance = new SimpleStringProperty();
    private final StringProperty time = new SimpleStringProperty();
    private final StringProperty popularity = new SimpleStringProperty();
    private final StringProperty childFriendliness = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final Property<Image> imagePath = new SimpleObjectProperty<>();

    public StringProperty getTourName() {
        return tourName;
    }
    public Property<Image> getImagePath() {
        return this.imagePath;
    }
    public StringProperty getFrom(){
        return this.from;
    }
    public StringProperty getTo(){
        return this.to;
    }
    public StringProperty getTransportType(){
        return this.transportType;
    }
    public StringProperty getDistance(){
        return this.distance;
    }
    public StringProperty getTime(){
        return this.time;
    }
    public StringProperty getPopularity(){
        return this.popularity;
    }
    public StringProperty getChildFriendliness(){
        return this.childFriendliness;
    }
    public StringProperty getDescription(){
        return this.description;
    }

    public TabPaneViewModel(SelectedTourService selectedTourService) {
        this.selectedTourService = selectedTourService;
        selectedTourService.addListener(this);
    }

    public Tour getSelectedTour() {
        return selectedTourService.getSelectedTour();
    }

    @Override
    public void update(Tour tour) {
        tourName.set(tour.getName());
        from.set("From: " + tour.getFrom());
        to.set("To: " + tour.getTo());
        transportType.set("Transport type: " + tour.getTransportType());
        distance.set("Distance in km: " + tour.getDistance());
        time.set("Time: " + tour.getTime());
        // popularity.set("Popularity: " + tour.getPopularity());
        childFriendliness.set("Child friendliness: " + tour.getChildFriendliness());
        description.set("Description: " + tour.getDescription());
        //https://stackoverflow.com/questions/7830951/how-can-i-load-computer-directory-images-in-javafx
        Image image = new Image(new File(tour.getImagePath()).toURI().toString());
        imagePath.setValue(image);
    }
}
