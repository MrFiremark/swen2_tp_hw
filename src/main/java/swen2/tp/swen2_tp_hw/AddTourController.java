package swen2.tp.swen2_tp_hw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.repository.TourRepository;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.util.UUID;

public class AddTourController {

    //private final TourService tourService;
    //private final TourRepository tourRepository;

    ObservableList<String> itemList = FXCollections.observableArrayList("Bike", "Walk", "Car");

    @FXML
    private TextField tf_tourname;
    @FXML
    private TextArea ta_description;
    @FXML
    private TextField tf_from;
    @FXML
    private TextField tf_to;
    @FXML
    private ChoiceBox cb_transportType;

    @FXML
    private void initialize(){
        cb_transportType.setValue("Transport type");
        cb_transportType.setItems(itemList);
    }

    //public AddTourController(TourService tourService, TourRepository tourRepository) {
    //    this.tourService = tourService;
    //    this.tourRepository = tourRepository;

    //}

    protected void onAddButtonClick(){
        Tour tour = new Tour(UUID.randomUUID().toString(), tf_tourname.getText(), ta_description.getText(), tf_from.getText(), tf_to.getText(), cb_transportType.getValue().toString());
        //tourRepository.addTour(tour);
        //tourService.updateTourList();
    }


}
