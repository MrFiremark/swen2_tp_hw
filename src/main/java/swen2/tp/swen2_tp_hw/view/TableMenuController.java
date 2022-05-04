package swen2.tp.swen2_tp_hw.view;

import javafx.fxml.FXML;
import swen2.tp.swen2_tp_hw.viewmodel.TableMenuViewModel;

public class TableMenuController {

    private final TableMenuViewModel tableMenuViewModel;

    public TableMenuController(TableMenuViewModel tableMenuViewModel) {
        this.tableMenuViewModel = tableMenuViewModel;
    }

    @FXML
    protected void onAddLogClick() {
        tableMenuViewModel.openAddTourWindow();
    }
}
