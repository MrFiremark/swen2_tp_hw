package swen2.tp.swen2_tp_hw.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class AddLogController {

    ObservableList<String> itemList = FXCollections.observableArrayList("Very Easy", "Easy", "Medium", "Hard", "Very Hard");

    @FXML
    private ChoiceBox cb_difficulty;

    @FXML
    private void initialize(){
        cb_difficulty.setValue("Difficulty");
        cb_difficulty.setItems(itemList);
    }
}
