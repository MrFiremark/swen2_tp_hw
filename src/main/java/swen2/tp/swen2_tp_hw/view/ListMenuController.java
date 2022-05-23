package swen2.tp.swen2_tp_hw.view;

import javafx.fxml.FXML;
import swen2.tp.swen2_tp_hw.viewmodel.ListMenuViewModel;

public class ListMenuController{

    private final ListMenuViewModel listMenuViewModel;

    public ListMenuController(ListMenuViewModel listMenuViewModel) {
        this.listMenuViewModel = listMenuViewModel;
    }

    @FXML
    protected void onAddTourClick() {
        listMenuViewModel.openAddTourWindow();
    }

    @FXML
    protected void onDeleteTourClick(){
        listMenuViewModel.deleteTour();
    }

    @FXML
    protected void onEditTourClick(){
        listMenuViewModel.openEditTourWindow();
    }

}
