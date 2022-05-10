package swen2.tp.swen2_tp_hw.viewmodel;

import swen2.tp.swen2_tp_hw.listener.SelectedTourListener;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.service.PDFService;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;

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

    public MainWindowViewModel(
            ListMenuViewModel listMenuViewModel,
            TourListViewModel tourListViewModel,
            SearchBarViewModel searchBarViewModel,
            TableMenuViewModel tableMenuViewModel,
            TourLogTableViewModel logTableViewModel,
            TabPaneViewModel tabPaneViewModel,
            PDFService pdfService,
            SelectedTourService selectedTourService
    ) {
        this.listMenuViewModel = listMenuViewModel;
        this.tourListViewModel = tourListViewModel;
        this.searchBarViewModel = searchBarViewModel;
        this.tableMenuViewModel = tableMenuViewModel;
        this.logTableViewModel = logTableViewModel;
        this.tabPaneViewModel = tabPaneViewModel;
        this.pdfService = pdfService;
        this.selectedTourService =selectedTourService;
        selectedTourService.addListener(this);
    }

    public void generateTourPDF(){
        try {
            pdfService.generateTourPDF(selectedTourService.getSelectedTour());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Tour tour){

    }
}
