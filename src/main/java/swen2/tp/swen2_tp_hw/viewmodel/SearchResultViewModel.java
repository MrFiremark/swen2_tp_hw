package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swen2.tp.swen2_tp_hw.model.Report;
import swen2.tp.swen2_tp_hw.model.SearchResult;
import swen2.tp.swen2_tp_hw.service.SearchService;

import java.util.ArrayList;

public class SearchResultViewModel {

    public final SearchService searchService;
    private ObservableList<SearchResult> observableResults = FXCollections.observableArrayList();

    public SearchResultViewModel(SearchService searchService) {
        this.searchService = searchService;
    }

    public void setObservableResults(String searchString){

        ArrayList<SearchResult> searchResults = searchService.getSearchResult(searchString);

        for (SearchResult searchResult: searchResults) {
            observableResults.add(searchResult);
        }
    }

    public ObservableList<SearchResult> getObservableResults(){ return observableResults; }

    public void clearObservableResults(){ observableResults.clear();}

}
