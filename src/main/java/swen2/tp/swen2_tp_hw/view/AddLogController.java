package swen2.tp.swen2_tp_hw.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.viewmodel.AddLogViewModel;

public class AddLogController {

    private final AddLogViewModel addLogViewModel;
    ObservableList<String> itemList = FXCollections.observableArrayList("Very Easy", "Easy", "Medium", "Hard", "Very Hard");


    @FXML
    private ChoiceBox cb_difficulty;

    @FXML
    private Button btn_add;

    public AddLogController(AddLogViewModel addLogViewModel) {
        this.addLogViewModel = addLogViewModel;
    }

    @FXML
    private void initialize(){
        cb_difficulty.setValue("Difficulty");
        cb_difficulty.setItems(itemList);
    }

    @FXML
    protected void onAddButtonClick(){
        addLogViewModel.saveTourLog();
        closeWindow();
    }

    private void closeWindow(){
        Stage stage = (Stage) btn_add.getScene().getWindow();
        stage.close();
    }
}
