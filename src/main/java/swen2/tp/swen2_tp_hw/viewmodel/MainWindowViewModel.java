package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.stage.FileChooser;
import swen2.tp.swen2_tp_hw.listener.SelectedTourListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.DataService;
import swen2.tp.swen2_tp_hw.service.PDFService;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.io.File;
import java.io.IOException;

public class MainWindowViewModel implements SelectedTourListener {

    private ListMenuViewModel listMenuViewModel;
    private TourListViewModel tourListViewModel;
    private SearchBarViewModel searchBarViewModel;
    private TableMenuViewModel tableMenuViewModel;
    private TourLogTableViewModel logTableViewModel;
    private TabPaneViewModel tabPaneViewModel;
    private PDFService pdfService;
    private SelectedTourService selectedTourService;
    private TourService tourService;
    private DataService dataService;

    public MainWindowViewModel(
            ListMenuViewModel listMenuViewModel,
            TourListViewModel tourListViewModel,
            SearchBarViewModel searchBarViewModel,
            TableMenuViewModel tableMenuViewModel,
            TourLogTableViewModel logTableViewModel,
            TabPaneViewModel tabPaneViewModel,
            PDFService pdfService,
            SelectedTourService selectedTourService,
            TourService tourService,
            DataService dataService
    ) {
        this.listMenuViewModel = listMenuViewModel;
        this.tourListViewModel = tourListViewModel;
        this.searchBarViewModel = searchBarViewModel;
        this.tableMenuViewModel = tableMenuViewModel;
        this.logTableViewModel = logTableViewModel;
        this.tabPaneViewModel = tabPaneViewModel;
        this.pdfService = pdfService;
        this.selectedTourService = selectedTourService;
        this.tourService = tourService;
        this.dataService = dataService;
        selectedTourService.addListener(this);
    }

    public void generateTourPDF(){
        try {
            pdfService.generateTourPDF(selectedTourService.getSelectedTour());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateSummaryPDF(){
        try {
            pdfService.generateSummaryPDF(tourService.getToursMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportTour(){
        dataService.exportTour(selectedTourService.getSelectedTour());
    }

    public void importTour(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Import File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JSON Files", "*.json"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(null);
        tourService.addTour(dataService.importTour(selectedFile.toString()));
    }

    @Override
    public void update(Tour tour){

    }
}
