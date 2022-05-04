package swen2.tp.swen2_tp_hw.viewmodel;

import swen2.tp.swen2_tp_hw.view.ListMenuController;

public class MainWindowViewModel {

    private ListMenuViewModel listMenuViewModel;
    private TourListViewModel tourListViewModel;
    private SearchBarViewModel searchBarViewModel;
    private TableMenuViewModel tableMenuViewModel;
    private LogTableViewModel logTableViewModel;

    public MainWindowViewModel(ListMenuViewModel listMenuViewModel, TourListViewModel tourListViewModel, SearchBarViewModel searchBarViewModel, TableMenuViewModel tableMenuViewModel, LogTableViewModel logTableViewModel) {
        this.listMenuViewModel = listMenuViewModel;
        this.tourListViewModel = tourListViewModel;
        this.searchBarViewModel = searchBarViewModel;
        this.tableMenuViewModel = tableMenuViewModel;
        this.logTableViewModel = logTableViewModel;
    }

}
