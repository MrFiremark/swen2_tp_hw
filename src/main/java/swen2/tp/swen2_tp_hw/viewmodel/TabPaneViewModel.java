package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import swen2.tp.swen2_tp_hw.listener.SelectedTourListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.AttributeService;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;

import java.awt.*;
import java.io.File;


public class TabPaneViewModel implements SelectedTourListener {

    private final SelectedTourService selectedTourService;
    private final AttributeService attributeService;

    private final StringProperty tourName = new SimpleStringProperty();
    private final StringProperty from = new SimpleStringProperty();
    private final StringProperty to = new SimpleStringProperty();
    private final StringProperty transportType = new SimpleStringProperty();
    private final StringProperty distance = new SimpleStringProperty();
    private final StringProperty time = new SimpleStringProperty();
    private final StringProperty childFriendliness = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final Property<Image> imagePath = new SimpleObjectProperty<>();
    private final BooleanProperty chartVisibility = new SimpleBooleanProperty(false);
    private final ObjectProperty<ObservableList<XYChart.Series>> ratingData = new SimpleObjectProperty<>();
    private final ObjectProperty<ObservableList<XYChart.Series>> difficultyData = new SimpleObjectProperty<>();

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
    public BooleanProperty getChartVisibility(){ return this.chartVisibility; }
    public ObjectProperty<ObservableList<XYChart.Series>> getRatingData(){ return ratingData; }
    public ObjectProperty<ObservableList<XYChart.Series>> getDifficultyData(){ return difficultyData; }
    public StringProperty getChildFriendliness(){
        return this.childFriendliness;
    }
    public StringProperty getDescription(){
        return this.description;
    }

    public TabPaneViewModel(SelectedTourService selectedTourService, AttributeService attributeService) {
        this.selectedTourService = selectedTourService;
        this.attributeService = attributeService;
        selectedTourService.addListener(this);
    }

    public Tour getSelectedTour() {
        return selectedTourService.getSelectedTour();
    }

    @Override
    public void update(Tour tour) {
        if(tour != null) {
            tourName.set(tour.getName());
            from.set("From: " + tour.getFrom());
            to.set("To: " + tour.getTo());
            transportType.set("Transport type: " + tour.getTransportType());
            distance.set("Distance: " + tour.getDistance() + " km");
            time.set("Time: " + tour.getTime());
            childFriendliness.set("Child friendliness: " + tour.getChildFriendliness());
            description.set("Description: \n" + tour.getDescription());
            //https://stackoverflow.com/questions/7830951/how-can-i-load-computer-directory-images-in-javafx
            Image image = new Image(new File(tour.getImagePath()).toURI().toString());
            imagePath.setValue(image);
            ratingData.set(loadRatingChart(tour));
            difficultyData.set(loadDifficultyChart(tour));
            chartVisibility.set(true);
        }else {
            tourName.set("");
            from.set("");
            to.set("");
            transportType.set("");
            distance.set("");
            time.set("");
            childFriendliness.set("");
            description.set("");
            imagePath.setValue(null);
            chartVisibility.set(false);
        }
    }

    public ObservableList<XYChart.Series> loadRatingChart(Tour tour){

        ObservableList<XYChart.Series> ratingData = FXCollections.observableArrayList();

        XYChart.Series series = new XYChart.Series();
        series.setName("Ranking");
        series.getData().add(new XYChart.Data("1 Stern", attributeService.getRating(tour, 1)));
        series.getData().add(new XYChart.Data("2 Sterne", attributeService.getRating(tour,2)));
        series.getData().add(new XYChart.Data("3 Sterne", attributeService.getRating(tour,3)));
        series.getData().add(new XYChart.Data("4 Sterne", attributeService.getRating(tour,4)));
        series.getData().add(new XYChart.Data("5 Sterne", attributeService.getRating(tour,5)));

        ratingData.add(series);
        return ratingData;
    }

    public ObservableList<XYChart.Series> loadDifficultyChart(Tour tour){

        ObservableList<XYChart.Series> difficultyData = FXCollections.observableArrayList();

        XYChart.Series series = new XYChart.Series();
        series.setName("Difficulty");
        series.getData().add(new XYChart.Data("Very Easy", attributeService.getDifficulty(tour,"Very Easy")));
        series.getData().add(new XYChart.Data("Easy", attributeService.getDifficulty(tour,"Easy")));
        series.getData().add(new XYChart.Data("Normal", attributeService.getDifficulty(tour,"Normal")));
        series.getData().add(new XYChart.Data("Hard", attributeService.getDifficulty(tour,"Hard")));
        series.getData().add(new XYChart.Data("Very Hard", attributeService.getDifficulty(tour,"Very Hard")));

        difficultyData.add(series);

        return difficultyData;
    }
}
