package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import swen2.tp.swen2_tp_hw.model.Report;
import swen2.tp.swen2_tp_hw.model.SearchResult;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;
import swen2.tp.swen2_tp_hw.service.SearchService;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.util.ArrayList;

public class SearchResultViewModel {

    private final SearchService searchService;
    private final TourService tourService;
    private final SelectedTourService selectedTourService;
    private final ObservableList<SearchResult> observableResults = FXCollections.observableArrayList();

    public SearchResultViewModel(TourService tourService, SelectedTourService selectedTourService, SearchService searchService) {
        this.tourService = tourService;
        this.selectedTourService = selectedTourService;
        this.searchService = searchService;
    }

    public void setObservableResults(String searchString){
        ArrayList<SearchResult> searchResults = searchService.getSearchResult(searchString);
        observableResults.addAll(searchResults);
    }


    public ObservableList<SearchResult> getObservableResults(){ return observableResults; }

    public void setSelectedSearchResult(int index){
        SearchResult searchResult = observableResults.get(index);
        Tour tour = tourService.getTourFromMap(searchResult.getTourid());
        selectedTourService.setSelectedTour(tour);
        if(!searchResult.getTourlogid().equals("")){
            TourLog tourLog = tourService.getTourLog(selectedTourService.getSelectedTour(), searchResult.getTourlogid());
            selectedTourService.setSetSelectedTourLog(tourLog);

        }
    }

    public void clearObservableResults(){ observableResults.clear();}

}
