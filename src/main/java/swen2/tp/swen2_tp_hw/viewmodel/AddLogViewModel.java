package swen2.tp.swen2_tp_hw.viewmodel;

import swen2.tp.swen2_tp_hw.model.TourLog;
//import swen2.tp.swen2_tp_hw.service.LogService;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;

public class AddLogViewModel {

    public final TourService tourService;
    public final SelectedTourService selectedTourService;

    public AddLogViewModel(TourService tourService, SelectedTourService selectedTourService) {
        this.tourService = tourService;
        this.selectedTourService = selectedTourService;
    }


    public void saveTourLog(){
        //TODO get properties and validation
        TourLog tourLog = new TourLog("tourID1", "logId2", "date3", "time4", "comment5", "totalTime6","diff7", "rating8");
        selectedTourService.addTourLog(tourLog);
    }


}
