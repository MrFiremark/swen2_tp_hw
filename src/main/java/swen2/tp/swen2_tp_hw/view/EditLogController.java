package swen2.tp.swen2_tp_hw.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.viewmodel.AddLogViewModel;
import swen2.tp.swen2_tp_hw.viewmodel.EditLogViewModel;

public class EditLogController {

    private final EditLogViewModel editLogViewModel;
    ObservableList<String> itemList = FXCollections.observableArrayList("Very Easy", "Easy", "Normal", "Hard", "Very Hard");

    @FXML
    private DatePicker dp_date;
    @FXML
    private TextArea ta_comment;
    @FXML
    private Slider sl_rating;
    @FXML
    private TextField tf_durationHour;
    @FXML
    private TextField tf_durationMin;
    @FXML
    private ChoiceBox cb_difficulty;
    @FXML
    private Button btn_edit;

    public EditLogController(EditLogViewModel editLogViewModel) {
        this.editLogViewModel = editLogViewModel;
    }

    @FXML
    private void initialize(){
        editLogViewModel.resetWindow();
        btn_edit.disableProperty().bind(editLogViewModel.getEnabled());
        dp_date.valueProperty().bindBidirectional(editLogViewModel.getDate());
        ta_comment.textProperty().bindBidirectional(editLogViewModel.getComment());
        sl_rating.valueProperty().bindBidirectional(editLogViewModel.getRating());
        tf_durationHour.textProperty().bindBidirectional(editLogViewModel.getDurationHour());
        tf_durationMin.textProperty().bindBidirectional(editLogViewModel.getDurationMin());
        cb_difficulty.setValue("Difficulty");
        cb_difficulty.setItems(itemList);
        cb_difficulty.valueProperty().bindBidirectional(editLogViewModel.getDifficulty());
    }

    @FXML
    protected void onEditButtonClick(){
        editLogViewModel.editTourLog();
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
