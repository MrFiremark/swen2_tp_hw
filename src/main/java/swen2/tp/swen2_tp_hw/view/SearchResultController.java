package swen2.tp.swen2_tp_hw.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import swen2.tp.swen2_tp_hw.model.SearchResult;
import swen2.tp.swen2_tp_hw.viewmodel.SearchResultViewModel;

public class SearchResultController {

    private final SearchResultViewModel searchResultViewModel;
    private ObservableList<SearchResult> searchResults = FXCollections.observableArrayList();

    @FXML
    private TableView<SearchResult> tv_searchTable;
    @FXML
    public TableColumn<SearchResult, String> type;
    @FXML
    public TableColumn<SearchResult, String> name;
    @FXML
    public TableColumn<SearchResult, String> description;
    @FXML
    public TableColumn<SearchResult, String> from;
    @FXML
    public TableColumn<SearchResult, String> to;
    @FXML
    public TableColumn<SearchResult, String> comment;
    @FXML
    public TableColumn<SearchResult, String> difficulty;

    public SearchResultController(SearchResultViewModel searchResultViewModel) {
        this.searchResultViewModel = searchResultViewModel;
    }

    public void initialize(String searchString){

        this.searchResults.addAll(searchResultViewModel.getSearchResults(searchString));

        type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        from.setCellValueFactory(new PropertyValueFactory<>("From"));
        to.setCellValueFactory(new PropertyValueFactory<>("To"));
        comment.setCellValueFactory(new PropertyValueFactory<>("Comment"));
        difficulty.setCellValueFactory(new PropertyValueFactory<>("Difficulty"));

        System.out.println(searchString);

        tv_searchTable.setItems(searchResults);
    }

}
