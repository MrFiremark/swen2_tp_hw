package swen2.tp.swen2_tp_hw.view;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.viewmodel.TabPaneViewModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TabPaneController {

    private final TabPaneViewModel tabPaneViewModel;

    @FXML
    private Label lbl_tourName;
    @FXML
    private Label lbl_from;
    @FXML
    private Label lbl_to;
    @FXML
    private Label lbl_transportType;
    @FXML
    private Label lbl_distance;
    @FXML
    private Label lbl_time;
    @FXML
    private Label lbl_childFriendliness;
    @FXML
    private Label lbl_description;
    @FXML
    private ImageView iv_map;
    @FXML
    private BarChart bc_rating;
    @FXML
    private BarChart bc_difficulty;

    public TabPaneController(TabPaneViewModel tabPaneViewModel) {
        this.tabPaneViewModel = tabPaneViewModel;
    }

    @FXML
    public void initialize(){
        lbl_tourName.textProperty().bind(tabPaneViewModel.getTourName());
        lbl_from.textProperty().bind(tabPaneViewModel.getFrom());
        lbl_to.textProperty().bind(tabPaneViewModel.getTo());
        lbl_transportType.textProperty().bind(tabPaneViewModel.getTransportType());
        lbl_distance.textProperty().bind(tabPaneViewModel.getDistance());
        lbl_time.textProperty().bind(tabPaneViewModel.getTime());
        lbl_childFriendliness.textProperty().bind(tabPaneViewModel.getChildFriendliness());
        lbl_description.textProperty().bind(tabPaneViewModel.getDescription());
        if(tabPaneViewModel.getImagePath() != null) {
            iv_map.imageProperty().bindBidirectional(tabPaneViewModel.getImagePath());
        }
        if(tabPaneViewModel.getSelectedTour() != null){
            loadRatingChart(tabPaneViewModel.getSelectedTour());
        }

        //loadPieChart();
    }

    public void loadRatingChart(Tour tour){

        XYChart.Series series = new XYChart.Series();
        series.setName("Ranking");
        series.getData().add(new XYChart.Data("1 Stern", tour.getRating(1)));
        series.getData().add(new XYChart.Data("2 Sterne", tour.getRating(2)));
        series.getData().add(new XYChart.Data("3 Sterne", tour.getRating(3)));
        series.getData().add(new XYChart.Data("4 Sterne", tour.getRating(4)));
        series.getData().add(new XYChart.Data("5 Sterne", tour.getRating(5)));

        bc_rating.getData().addAll(series);
    }

    public void loadDifficultyCharts(Tour tour){

        XYChart.Series series = new XYChart.Series();
        series.setName("Difficulty");
        series.getData().add(new XYChart.Data("Very Easy", tour.getRating(1)));
        series.getData().add(new XYChart.Data("Easy", tour.getRating(2)));
        series.getData().add(new XYChart.Data("Normal", tour.getRating(3)));
        series.getData().add(new XYChart.Data("Hard", tour.getRating(4)));
        series.getData().add(new XYChart.Data("Very Hard", tour.getRating(5)));

        bc_rating.getData().addAll(series);
    }

    public void loadPieChart(){

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Very Easy", 13),
                        new PieChart.Data("Easy", 25),
                        new PieChart.Data("Medium", 10),
                        new PieChart.Data("Hard", 22),
                        new PieChart.Data("Very Hard", 30));
        //pc_rating.setData(pieChartData);
        //pc_rating.setTitle("Tour Difficulty");
    }
}
