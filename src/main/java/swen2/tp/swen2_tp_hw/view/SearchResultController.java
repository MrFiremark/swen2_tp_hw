package swen2.tp.swen2_tp_hw.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import swen2.tp.swen2_tp_hw.model.SearchResult;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.viewmodel.SearchResultViewModel;

public class SearchResultController {

    private final SearchResultViewModel searchResultViewModel;
    @FXML
    private TableView<SearchResult> tv_searchTable;
    @FXML
    public TableColumn<SearchResult, String> tbc_type;
    @FXML
    public TableColumn<SearchResult, String> tbc_name;
    @FXML
    public TableColumn<SearchResult, String> tbc_description;
    @FXML
    public TableColumn<SearchResult, String> tbc_from;
    @FXML
    public TableColumn<SearchResult, String> tbc_to;
    @FXML
    public TableColumn<SearchResult, String> tbc_comment;
    @FXML
    public TableColumn<SearchResult, String> tbc_difficulty;

    public SearchResultController(SearchResultViewModel searchResultViewModel) {
        this.searchResultViewModel = searchResultViewModel;
    }

    public void initialize(String searchString){

        searchResultViewModel.clearObservableResults();
        System.out.println(searchString);
        searchResultViewModel.setObservableResults(searchString);

        tv_searchTable.getItems().clear();
        tbc_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        tbc_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tbc_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        tbc_from.setCellValueFactory(new PropertyValueFactory<>("from"));
        tbc_to.setCellValueFactory(new PropertyValueFactory<>("to"));
        tbc_comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        tbc_difficulty.setCellValueFactory(new PropertyValueFactory<>("difficulty"));

        tv_searchTable.setItems(searchResultViewModel.getObservableResults());



        tv_searchTable.setRowFactory( tv -> {
            TableRow<SearchResult> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    SearchResult rowData = row.getItem();
                    //TODO implement index property
                    searchResultViewModel.setSelectedSearchResult();
                }
            });
            return row ;
        });
    }

}
