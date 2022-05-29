package swen2.tp.swen2_tp_hw.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.viewmodel.AddLogViewModel;

public class AddLogController {

    private final AddLogViewModel addLogViewModel;
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
    private Button btn_add;

    public AddLogController(AddLogViewModel addLogViewModel) {
        this.addLogViewModel = addLogViewModel;
    }

    @FXML
    private void initialize(){
        addLogViewModel.resetWindow();
        btn_add.disableProperty().bind(addLogViewModel.getEnabled());
        dp_date.valueProperty().bindBidirectional(addLogViewModel.getDate());
        ta_comment.textProperty().bindBidirectional(addLogViewModel.getComment());
        sl_rating.valueProperty().bindBidirectional(addLogViewModel.getRating());
        tf_durationHour.textProperty().bindBidirectional(addLogViewModel.getDurationHour());
        tf_durationMin.textProperty().bindBidirectional(addLogViewModel.getDurationMin());
        cb_difficulty.setValue("Difficulty");
        cb_difficulty.setItems(itemList);
        cb_difficulty.valueProperty().bindBidirectional(addLogViewModel.getDifficulty());

    }

    @FXML
    protected void onAddButtonClick(){
        addLogViewModel.saveTourLog();
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
