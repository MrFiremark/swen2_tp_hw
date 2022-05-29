package swen2.tp.swen2_tp_hw.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;

import static org.junit.jupiter.api.Assertions.*;

class SelectedTourServiceTest {

    @Test
    void testGetSelectedTour(){
        Tour tour = new Tour("id", "name", "description", "from", "to", "transportType");
        SelectedTourService selectedTourService = new SelectedTourService();
        selectedTourService.setSelectedTour(tour);
        assertEquals(tour, selectedTourService.getSelectedTour());
    }

    @Test
    void testGetSelectedTourLog(){
        Tour tour = new Tour("id", "name", "description", "from", "to", "transportType" );
        SelectedTourService selectedTourService = new SelectedTourService();
        selectedTourService.setSelectedTour(tour);
        TourLog tourLog = new TourLog("id", "tid", "date", "time", "comment", "difficulty", "totaltime", "rating");
        selectedTourService.setSetSelectedTourLog(tourLog);
        assertEquals(tourLog, selectedTourService.getSelectedTourLog());

    }

}