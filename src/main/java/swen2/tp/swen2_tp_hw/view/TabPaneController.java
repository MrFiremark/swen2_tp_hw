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
        bc_rating.visibleProperty().bindBidirectional(tabPaneViewModel.getChartVisibility());
        bc_difficulty.visibleProperty().bindBidirectional(tabPaneViewModel.getChartVisibility());
        lbl_tourName.textProperty().bind(tabPaneViewModel.getTourName());
        lbl_from.textProperty().bind(tabPaneViewModel.getFrom());
        lbl_to.textProperty().bind(tabPaneViewModel.getTo());
        lbl_transportType.textProperty().bind(tabPaneViewModel.getTransportType());
        lbl_distance.textProperty().bind(tabPaneViewModel.getDistance());
        lbl_time.textProperty().bind(tabPaneViewModel.getTime());
        lbl_childFriendliness.textProperty().bind(tabPaneViewModel.getChildFriendliness());
        lbl_description.textProperty().bind(tabPaneViewModel.getDescription());
        iv_map.imageProperty().bindBidirectional(tabPaneViewModel.getImagePath());
        bc_rating.dataProperty().bindBidirectional(tabPaneViewModel.getRatingData());
        //bc_difficulty.dataProperty().bindBidirectional();

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

}
