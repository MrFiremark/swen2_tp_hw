package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import swen2.tp.swen2_tp_hw.model.Report;
import swen2.tp.swen2_tp_hw.model.SearchResult;
import swen2.tp.swen2_tp_hw.service.SearchService;

import java.util.ArrayList;

public class SearchResultViewModel {

    public final SearchService searchService;
    private final ObservableList<SearchResult> observableResults = FXCollections.observableArrayList();

    public SearchResultViewModel(SearchService searchService) {
        this.searchService = searchService;
    }

    public void setObservableResults(String searchString){

        ArrayList<SearchResult> searchResults = searchService.getSearchResult(searchString);

        observableResults.addAll(searchResults);
    }


    public ObservableList<SearchResult> getObservableResults(){ return observableResults; }

    public void setSelectedSearchResult(){
        //TODO get index from table view and then get tour id
        // maybe with change listener
    }

    public void clearObservableResults(){ observableResults.clear();}

}
