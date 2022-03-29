package swen2.tp.swen2_tp_hw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.AddLogApplication;
import swen2.tp.swen2_tp_hw.AddTourApplication;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.repository.TourRepository;
import swen2.tp.swen2_tp_hw.service.TourService;
import swen2.tp.swen2_tp_hw.viewmodel.MainWindowViewModel;

import java.io.IOException;
import java.util.Map;

public class MainWindowController {

    TourService tourService = new TourService();
    TourRepository tourRepository = new TourRepository();

    private final MainWindowViewModel mainWindowViewModel;

    @FXML private ListView lv_tourList;

    public MainWindowController(MainWindowViewModel mainWindowViewModel) {
        this.mainWindowViewModel = mainWindowViewModel;
    }

    @FXML
    protected void onAddTourClick() {
        AddTourApplication addTourApplication = new AddTourApplication();
        try {
            addTourApplication.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onAddLogClick(){
        AddLogApplication addLogApplication = new AddLogApplication();
        try {
            addLogApplication.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void refreshTourList(Map tourList){
        lv_tourList.getItems().clear();
        lv_tourList.getItems().addAll(tourList);
    }


}