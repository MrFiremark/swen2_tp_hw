package swen2.tp.swen2_tp_hw.view;

import swen2.tp.swen2_tp_hw.service.LogService;
import swen2.tp.swen2_tp_hw.service.SelectedItemService;
import swen2.tp.swen2_tp_hw.service.TourService;
import swen2.tp.swen2_tp_hw.viewmodel.*;

public class ControllerFactory {

    private final MainWindowViewModel mainWindowViewModel;
    private final SearchBarViewModel searchBarViewModel;
    private final TourListViewModel tourListViewModel;
    private final ListMenuViewModel listMenuViewModel;
    private final AddTourViewModel addTourViewModel;
    private final LogTableViewModel logTableViewModel;
    private final TableMenuViewModel tableMenuViewModel;
    private final TabPaneViewModel tabPaneViewModel;
    private final TourService tourService;
    private final LogService logService;
    private final SelectedItemService selectedItemService;

    public ControllerFactory() {
        tourService = new TourService();
        logService = new LogService();
        selectedItemService = new SelectedItemService();
        searchBarViewModel = new SearchBarViewModel();
        tourListViewModel = new TourListViewModel(tourService, selectedItemService);
        listMenuViewModel = new ListMenuViewModel(tourService, selectedItemService);
        logTableViewModel = new LogTableViewModel(logService);
        tableMenuViewModel = new TableMenuViewModel();
        tabPaneViewModel = new TabPaneViewModel(selectedItemService);
        mainWindowViewModel = new MainWindowViewModel(
                listMenuViewModel,
                tourListViewModel,
                searchBarViewModel,
                tableMenuViewModel,
                logTableViewModel,
                tabPaneViewModel
        );
        addTourViewModel = new AddTourViewModel(tourService);
    }

    //
    // Factory-Method Pattern
    //
    public Object create(Class<?> controllerClass) {
        if (controllerClass == MainWindowController.class) {
            return new MainWindowController(mainWindowViewModel);
        } else if (controllerClass == SearchBarController.class) {
            return new SearchBarController(searchBarViewModel);
        } else if (controllerClass == TourListController.class) {
            return new TourListController(tourListViewModel);
        } else if (controllerClass == ListMenuController.class) {
            return new ListMenuController(listMenuViewModel);
        } else if (controllerClass == AddTourController.class) {
            return new AddTourController(addTourViewModel);
        } else if (controllerClass == TableMenuController.class){
            return new TableMenuController(tableMenuViewModel);
        } else if (controllerClass == LogTableController.class){
            return new LogTableController(logTableViewModel);
        } else if (controllerClass == TabPaneController.class){
            return new TabPaneController(tabPaneViewModel);
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
