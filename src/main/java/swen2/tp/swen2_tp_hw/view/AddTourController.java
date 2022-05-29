package swen2.tp.swen2_tp_hw.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.viewmodel.AddTourViewModel;

public class AddTourController {

    //private final TourService tourService;
    //private final TourRepository tourRepository;

    ObservableList<String> itemList = FXCollections.observableArrayList("Bike", "Walk", "Car");

    private final AddTourViewModel addTourViewModel;

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
    private Button btn_add;

    public AddTourController(AddTourViewModel addTourViewModel){
        this.addTourViewModel = addTourViewModel;
    }

    @FXML
    public void initialize(){
        addTourViewModel.resetWindow();
        btn_add.disableProperty().bind(addTourViewModel.getEnabled());
        tf_tourname.textProperty().bindBidirectional(addTourViewModel.getTourName());
        ta_description.textProperty().bindBidirectional(addTourViewModel.getDescription());
        tf_to.textProperty().bindBidirectional(addTourViewModel.getTo());
        tf_from.textProperty().bindBidirectional(addTourViewModel.getFrom());
        cb_transportType.setValue("Transport type");
        cb_transportType.setItems(itemList);
        cb_transportType.valueProperty().bindBidirectional(addTourViewModel.getTransportType());
    }

    @FXML
    protected void onAddButtonClick(){
        addTourViewModel.saveTour();
        closeWindow();
    }

    @FXML
    protected void onCancelButtonClick(){
        closeWindow();
    }

    private void closeWindow(){
        Stage stage = (Stage) btn_add.getScene().getWindow();
        stage.close();
    }
}
