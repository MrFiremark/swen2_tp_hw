package swen2.tp.swen2_tp_hw.view;


import swen2.tp.swen2_tp_hw.service.*;
import swen2.tp.swen2_tp_hw.viewmodel.*;

public class ControllerFactory {

    private final MainWindowViewModel mainWindowViewModel;
    private final SearchBarViewModel searchBarViewModel;
    private final TourListViewModel tourListViewModel;
    private final ListMenuViewModel listMenuViewModel;
    private final AddTourViewModel addTourViewModel;
    private final AddLogViewModel addLogViewModel;
    private final EditTourViewModel editTourViewModel;
    private final EditLogViewModel editLogViewModel;
    private final TourLogTableViewModel tourLogTableViewModel;
    private final TableMenuViewModel tableMenuViewModel;
    private final TabPaneViewModel tabPaneViewModel;
    private final SearchResultViewModel searchResultViewModel;
    private final TourService tourService;
    private final SelectedTourService selectedTourService;
    private final PDFService pdfService;
    private final SearchService searchService;
    private final AttributeService attributeService;
    private final DataService dataService;

    public ControllerFactory() {
        tourService = new TourService();
        pdfService = new PDFService();
        selectedTourService = new SelectedTourService();
        searchService = new SearchService();
        searchBarViewModel = new SearchBarViewModel();
        attributeService = new AttributeService();
        dataService = new DataService();
        searchResultViewModel = new SearchResultViewModel(tourService, selectedTourService, searchService);
        tourListViewModel = new TourListViewModel(tourService, selectedTourService);
        listMenuViewModel = new ListMenuViewModel(tourService, selectedTourService);
        tourLogTableViewModel = new TourLogTableViewModel(selectedTourService);
        tableMenuViewModel = new TableMenuViewModel(selectedTourService);
        tabPaneViewModel = new TabPaneViewModel(selectedTourService, attributeService);
        addTourViewModel = new AddTourViewModel(tourService);
        addLogViewModel = new AddLogViewModel(selectedTourService);
        editTourViewModel = new EditTourViewModel(tourService, selectedTourService);
        editLogViewModel = new EditLogViewModel(selectedTourService);
        mainWindowViewModel = new MainWindowViewModel(
                listMenuViewModel,
                tourListViewModel,
                searchBarViewModel,
                tableMenuViewModel,
                tourLogTableViewModel,
                tabPaneViewModel,
                pdfService,
                selectedTourService,
                tourService,
                dataService
        );

    }
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
            return new TourLogTableController(tourLogTableViewModel);
        } else if (controllerClass == TabPaneController.class){
            return new TabPaneController(tabPaneViewModel);
        } else if (controllerClass == SearchResultController.class){
            return new SearchResultController(searchResultViewModel);
        } else if (controllerClass == EditTourController.class){
            return new EditTourController(editTourViewModel);
        }else if (controllerClass == EditLogController.class){
            return new EditLogController(editLogViewModel);
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
