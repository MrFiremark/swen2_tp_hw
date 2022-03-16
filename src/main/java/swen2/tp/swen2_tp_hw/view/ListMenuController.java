package swen2.tp.swen2_tp_hw.view;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.AddTourApplication;

import java.io.IOException;

public class ListMenuController {

    @FXML
    protected void onAddTourClick() {
        AddTourApplication addTourApplication = new AddTourApplication();
        try {
            addTourApplication.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
