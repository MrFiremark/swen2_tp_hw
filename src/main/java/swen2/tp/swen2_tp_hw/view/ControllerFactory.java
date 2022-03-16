package swen2.tp.swen2_tp_hw.view;

import swen2.tp.swen2_tp_hw.viewmodel.ListMenuViewModel;
import swen2.tp.swen2_tp_hw.viewmodel.MainWindowViewModel;
import swen2.tp.swen2_tp_hw.viewmodel.SearchBarViewModel;
import swen2.tp.swen2_tp_hw.viewmodel.TourListViewModel;

public class ControllerFactory {
    private final MainWindowViewModel mainWindowViewModel;
    private final SearchBarViewModel searchBarViewModel;
    private final TourListViewModel tourListViewModel;
    private final ListMenuViewModel listMenuViewModel;

    public ControllerFactory() {
        searchBarViewModel = new SearchBarViewModel();
        tourListViewModel = new TourListViewModel();
        listMenuViewModel = new ListMenuViewModel();
        mainWindowViewModel = new MainWindowViewModel(searchBarViewModel, tourListViewModel, listMenuViewModel);
    }

    //
    // Factory-Method Pattern
    //
    public Object create(Class<?> controllerClass) {
        if (controllerClass == MainWindowController.class) {
            return new MainWindowController(mainWindowViewModel);
        } else if (controllerClass == SearchBarController.class) {
            return new SearchBarController(searchBarViewModel);
        } else if (controllerClass == MediaDetailsController.class) {
            return new MediaDetailsController(mediaDetailsViewModel);
        } else if (controllerClass == MediaOverviewController.class) {
            return new MediaOverviewController(mediaOverviewViewModel);
        }
        throw new IllegalArgumentException("Unknown controller class: " + controllerClass);
    }


    //
    // Singleton-Pattern with early-binding
    //
    private static ControllerFactory instance = new ControllerFactory();

    public static ControllerFactory getInstance() {
        return instance;
    }

}
