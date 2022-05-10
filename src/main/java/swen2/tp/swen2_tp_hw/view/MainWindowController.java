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

    private final MainWindowViewModel mainWindowViewModel;

    public MainWindowController(MainWindowViewModel mainWindowViewModel) {
        this.mainWindowViewModel = mainWindowViewModel;
    }

    @FXML
    public void onMenuClickTourReport(){
        mainWindowViewModel.generateTourPDF();
    }
}