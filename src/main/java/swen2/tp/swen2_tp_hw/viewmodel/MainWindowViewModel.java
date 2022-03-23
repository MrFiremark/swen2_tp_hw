package swen2.tp.swen2_tp_hw.viewmodel;

import swen2.tp.swen2_tp_hw.view.ListMenuController;

public class MainWindowViewModel {

    private ListMenuViewModel listMenuViewModel;
    private TourListViewModel tourListViewModel;
    private SearchBarViewModel searchBarViewModel;

    public MainWindowViewModel(SearchBarViewModel searchBarViewModel, TourListViewModel tourListViewModel, ListMenuViewModel listMenuViewModel) {
        this.searchBarViewModel = searchBarViewModel;
        this.listMenuViewModel = listMenuViewModel;
        this.tourListViewModel = tourListViewModel;
    }


}
