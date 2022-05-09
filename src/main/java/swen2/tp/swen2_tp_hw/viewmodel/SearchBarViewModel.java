package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import swen2.tp.swen2_tp_hw.FXMLDependencyInjection;
import swen2.tp.swen2_tp_hw.view.SearchResultController;

import java.io.IOException;
import java.util.Locale;

public class SearchBarViewModel {

    public void openSearchResultWindow(String search){
        try {

            FXMLLoader loader = FXMLDependencyInjection.getLoader("searchResult.fxml", Locale.ENGLISH);

            Parent root = loader.load();//FXMLDependencyInjection.load("searchResult.fxml", Locale.ENGLISH);
            SearchResultController searchResultController = loader.<SearchResultController>getController();
            searchResultController.initialize(search);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Search Result");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
