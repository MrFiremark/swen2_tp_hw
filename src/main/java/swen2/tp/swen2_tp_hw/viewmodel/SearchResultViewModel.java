package swen2.tp.swen2_tp_hw.viewmodel;

import swen2.tp.swen2_tp_hw.model.SearchResult;
import swen2.tp.swen2_tp_hw.service.SearchService;

import java.util.ArrayList;

public class SearchResultViewModel {

    public final SearchService searchService;

    public SearchResultViewModel(SearchService searchService) {
        this.searchService = searchService;
    }

    public ArrayList<SearchResult> getSearchResults(String search){
        return searchService.getSearchResult(search);
    }
}
