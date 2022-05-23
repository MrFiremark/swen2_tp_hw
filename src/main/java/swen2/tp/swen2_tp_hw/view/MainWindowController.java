package swen2.tp.swen2_tp_hw.view;

import javafx.fxml.FXML;
import swen2.tp.swen2_tp_hw.viewmodel.MainWindowViewModel;

public class MainWindowController {

    private final MainWindowViewModel mainWindowViewModel;

    public MainWindowController(MainWindowViewModel mainWindowViewModel) {
        this.mainWindowViewModel = mainWindowViewModel;
    }

    @FXML
    public void onMenuClickTourReport(){
        mainWindowViewModel.generateTourPDF();
    }

    @FXML
    public void onMenuClickSummaryReport(){
        mainWindowViewModel.generateSummaryPDF();
    }
}