package swen2.tp.swen2_tp_hw.service;

import swen2.tp.swen2_tp_hw.model.SearchResult;
import swen2.tp.swen2_tp_hw.repository.SearchRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchService {

    private SearchRepository searchRepository = new SearchRepository();

    public ArrayList<SearchResult> getSearchResult(String searchString){

        ArrayList<SearchResult> searchResults = new ArrayList<>();

        try {
            searchResults = searchRepository.getSearchResult(searchString);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchResults;
    }
}
