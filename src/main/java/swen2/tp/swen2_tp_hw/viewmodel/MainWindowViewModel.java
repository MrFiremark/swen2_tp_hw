package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import swen2.tp.swen2_tp_hw.listener.SelectedTourListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.DataService;
import swen2.tp.swen2_tp_hw.service.PDFService;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;
import swen2.tp.swen2_tp_hw.wrapper.ILoggerWrapper;
import swen2.tp.swen2_tp_hw.wrapper.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class MainWindowViewModel {

    private ILoggerWrapper logger = LoggerFactory.getLogger();

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
    }

    public void generateTourPDF(){
        if(selectedTourService.getSelectedTour() != null){
            try {
                pdfService.generateTourPDF(selectedTourService.getSelectedTour());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            logger.warn("Report error[1000]. No tour selected.");
            createErrorDialog("Error creating Report!", "No tour selected!");
        }
    }

    public void generateSummaryPDF(){
        if(selectedTourService.getSelectedTour().getTourLogs().size() > 0){
            try {
                pdfService.generateSummaryPDF(tourService.getToursMap());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            logger.warn("Summary error[err:1001]. No tour logs created.");
            createErrorDialog("Error creating Summary!", "No tour logs created!");
        }
    }

    public void exportTour(){
        if(selectedTourService.getSelectedTour() != null){
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Export File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("JSON Files", "*.json"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));
            File selectedFile = fileChooser.showSaveDialog(null);
            dataService.exportTour(selectedTourService.getSelectedTour(), selectedFile.toString());
        }
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

    private void createErrorDialog(String header, String content){
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText(header);
        dialog.setContentText(content);
        dialog.showAndWait();
    }
}
