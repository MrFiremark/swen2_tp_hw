package swen2.tp.swen2_tp_hw.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.viewmodel.EditTourViewModel;

public class EditTourController {


    ObservableList<String> itemList = FXCollections.observableArrayList("Bike", "Walk", "Car");

    private final EditTourViewModel editTourViewModel;

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
    private Button btn_edit;


    public EditTourController(EditTourViewModel editTourViewModel){
        this.editTourViewModel = editTourViewModel;
    }

    @FXML
    public void initialize(){
        btn_edit.disableProperty().bind(editTourViewModel.getEnabled());
        tf_tourname.textProperty().bindBidirectional(editTourViewModel.getTourName());
        ta_description.textProperty().bindBidirectional(editTourViewModel.getDescription());
        tf_to.textProperty().bindBidirectional(editTourViewModel.getTo());
        tf_from.textProperty().bindBidirectional(editTourViewModel.getFrom());
        cb_transportType.setValue("Transport type");
        cb_transportType.setItems(itemList);
        cb_transportType.valueProperty().bindBidirectional(editTourViewModel.getTransportType());
    }

    @FXML
    protected void onEditButtonClick(){
        editTourViewModel.editTour();
        closeWindow();
    }

    @FXML
    protected void onCancelButtonClick(){
        closeWindow();
    }

    private void closeWindow(){
        Stage stage = (Stage) btn_edit.getScene().getWindow();
        stage.close();
    }
}
