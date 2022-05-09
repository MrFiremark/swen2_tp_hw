package swen2.tp.swen2_tp_hw.view;

import swen2.tp.swen2_tp_hw.viewmodel.SearchResultViewModel;

public class SearchResultController {

    private final SearchResultViewModel searchResultViewModel;

    public SearchResultController(SearchResultViewModel searchResultViewModel) {
        this.searchResultViewModel = searchResultViewModel;
    }

    public void initialize(String searchString){
        System.out.println(searchString);
    }
}
