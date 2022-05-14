package swen2.tp.swen2_tp_hw.view;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
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
    private Label lbl_popularity;
    @FXML
    private Label lbl_childFriendliness;
    @FXML
    private Label lbl_description;
    @FXML
    private ImageView iv_map;
    @FXML
    private PieChart pc_rating;

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
        lbl_popularity.textProperty().bind(tabPaneViewModel.getPopularity());
        lbl_childFriendliness.textProperty().bind(tabPaneViewModel.getChildFriendliness());
        lbl_description.textProperty().bind(tabPaneViewModel.getDescription());
        if(tabPaneViewModel.getImagePath() != null) {
            iv_map.imageProperty().bindBidirectional(tabPaneViewModel.getImagePath());
        }
        //changeMap(tabPaneViewModel.getImagePath());
        loadChart();
    }

    public void changeMap(String path){
        if(path != null){
            System.out.println(path);
            Image image = new Image(String.valueOf(new File(path)));
            iv_map.setImage(image);
            iv_map.setImage(new Image(String.valueOf(new File(path))));
        }
    }

    public void loadChart(){

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Very Easy", 13),
                        new PieChart.Data("Easy", 25),
                        new PieChart.Data("Medium", 10),
                        new PieChart.Data("Hard", 22),
                        new PieChart.Data("Very Hard", 30));
        pc_rating.setData(pieChartData);
        pc_rating.setTitle("Tour Difficulty");
    }
}
