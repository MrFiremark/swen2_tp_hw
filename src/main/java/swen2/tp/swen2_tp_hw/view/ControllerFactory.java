package swen2.tp.swen2_tp_hw.view;

import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;
import swen2.tp.swen2_tp_hw.viewmodel.*;

public class ControllerFactory {

    private final MainWindowViewModel mainWindowViewModel;
    private final SearchBarViewModel searchBarViewModel;
    private final TourListViewModel tourListViewModel;
    private final ListMenuViewModel listMenuViewModel;
    private final AddTourViewModel addTourViewModel;
    private final AddLogViewModel addLogViewModel;
    private final TourLogTableViewModel logTableViewModel;
    private final TableMenuViewModel tableMenuViewModel;
    private final TabPaneViewModel tabPaneViewModel;
    private final TourService tourService;
    //private final LogService logService;
    private final SelectedTourService selectedTourService;

    public ControllerFactory() {
        tourService = new TourService();
        //logService = new LogService();
        selectedTourService = new SelectedTourService();
        searchBarViewModel = new SearchBarViewModel();
        tourListViewModel = new TourListViewModel(tourService, selectedTourService);
        listMenuViewModel = new ListMenuViewModel(tourService, selectedTourService);
        logTableViewModel = new TourLogTableViewModel(selectedTourService);
        tableMenuViewModel = new TableMenuViewModel(selectedTourService);
        tabPaneViewModel = new TabPaneViewModel(selectedTourService);
        addTourViewModel = new AddTourViewModel(tourService);
        addLogViewModel = new AddLogViewModel(tourService, selectedTourService);
        mainWindowViewModel = new MainWindowViewModel(
                listMenuViewModel,
                tourListViewModel,
                searchBarViewModel,
                tableMenuViewModel,
                logTableViewModel,
                tabPaneViewModel
        );

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
        } else if (controllerClass == AddLogController.class) {
            return new AddLogController(addLogViewModel);
        } else if (controllerClass == TableMenuController.class){
            return new TableMenuController(tableMenuViewModel);
        } else if (controllerClass == TourLogTableController.class){
            return new TourLogTableController(logTableViewModel);
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
