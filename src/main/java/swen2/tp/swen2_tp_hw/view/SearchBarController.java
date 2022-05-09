package swen2.tp.swen2_tp_hw.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import swen2.tp.swen2_tp_hw.viewmodel.SearchBarViewModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchBarController {

    private final SearchBarViewModel searchBarViewModel;

    public SearchBarController(SearchBarViewModel searchBarViewModel) {
        this.searchBarViewModel = searchBarViewModel;
    }

    @FXML
    private TextField tf_searchBar;

    @FXML
    protected void onSearchPress() {
        searchBarViewModel.openSearchResultWindow(tf_searchBar.getText());


    }

}
