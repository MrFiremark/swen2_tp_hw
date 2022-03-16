package swen2.tp.swen2_tp_hw.viewmodel;

import swen2.tp.swen2_tp_hw.view.ListMenuController;

public class MainWindowViewModel {
    private ListMenuViewModel listMenuViewModel;
    private TourListViewModel tourListViewModel;

    public MainWindowViewModel(ListMenuViewModel listMenuViewModel, TourListViewModel tourListViewModel) {
        this.listMenuViewModel = listMenuViewModel;
        this.tourListViewModel = tourListViewModel;
    }


}
