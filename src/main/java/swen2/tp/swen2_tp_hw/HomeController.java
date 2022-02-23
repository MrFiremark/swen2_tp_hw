package swen2.tp.swen2_tp_hw;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onAddTourClick() {
        AddTourApplikation addTourApplikation = new AddTourApplikation();
        try {
            addTourApplikation.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}