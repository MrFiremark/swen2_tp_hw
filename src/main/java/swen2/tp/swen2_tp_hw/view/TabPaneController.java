package swen2.tp.swen2_tp_hw.view;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        changeMap(tabPaneViewModel.getImagePath());
    }

    public void changeMap(String path){
        if(path != null){
            System.out.println(path);
            System.out.println(path);
            Image image = new Image(String.valueOf(new File(path)));
            iv_map.setImage(image);
        }

    }
}
