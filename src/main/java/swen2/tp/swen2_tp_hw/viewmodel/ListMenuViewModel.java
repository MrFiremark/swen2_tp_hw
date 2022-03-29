package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.AddTourApplication;

import java.io.IOException;

public class ListMenuViewModel {
    public void openAddTourWindow(){
        AddTourApplication addTourApplication = new AddTourApplication();
        try {
            addTourApplication.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
