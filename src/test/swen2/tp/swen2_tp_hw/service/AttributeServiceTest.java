package swen2.tp.swen2_tp_hw.service;

import org.junit.jupiter.api.Test;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;

import static org.junit.jupiter.api.Assertions.*;

class AttributeServiceTest {

    @Test
    void testChildFriendliness() {
        AttributeService attributeService = new AttributeService();
        Tour tour = new Tour("id", "name", "description", "from", "to", "transporttype", 3, "time", "imagepath");
        TourLog tourLog1 = new TourLog("id", "tid", "date", "time", "comment", "Easy", "00:20", "rating");
        TourLog tourLog2 = new TourLog("id", "tid2", "date2", "time2", "comment2", "Hard", "00:50", "rating");
        tour.addTourLog(tourLog1);
        tour.addTourLog(tourLog2);
        String childFriendliness = attributeService.setChildFriendliness(tour);
        assertEquals("Child Friendly", childFriendliness);
    }

    @Test
    void testNotChildFriendliness() {
        AttributeService attributeService = new AttributeService();
        Tour tour = new Tour("id", "name", "description", "from", "to", "transporttype", 50, "time", "imagepath");
        TourLog tourLog1 = new TourLog("id", "tid", "date", "time", "comment", "Hard", "05:50", "rating");
        TourLog tourLog2 = new TourLog("id", "tid2", "date2", "time2", "comment2", "Very Hard", "03:50", "rating");
        tour.addTourLog(tourLog1);
        tour.addTourLog(tourLog2);
        String childFriendliness = attributeService.setChildFriendliness(tour);
        assertEquals("NOT Child Friendly", childFriendliness);
    }

    @Test
    void testGetRating() {
        AttributeService attributeService = new AttributeService();
        Tour tour = new Tour("id", "name", "description", "from", "to", "transporttype", 50, "time", "imagepath");
        TourLog tourLog1 = new TourLog("id", "tid", "date", "time", "comment", "Hard", "05:50", "2");
        TourLog tourLog2 = new TourLog("id", "tid2", "date2", "time2", "comment2", "Very Hard", "03:50", "1");
        TourLog tourLog3 = new TourLog("id", "tid3", "date3", "time3", "comment3", "Very Hard", "03:50", "1");
        tour.addTourLog(tourLog1);
        tour.addTourLog(tourLog2);
        tour.addTourLog(tourLog3);
        assertEquals(2, attributeService.getRating(tour, 1));
        assertEquals(1, attributeService.getRating(tour, 2));
    }

    @Test
    void getDifficulty() {
        AttributeService attributeService = new AttributeService();
        Tour tour = new Tour("id", "name", "description", "from", "to", "transporttype", 50, "time", "imagepath");
        TourLog tourLog1 = new TourLog("id", "tid", "date", "time", "comment", "Hard", "05:50", "2");
        TourLog tourLog2 = new TourLog("id", "tid2", "date2", "time2", "comment2", "Very Hard", "03:50", "1");
        TourLog tourLog3 = new TourLog("id", "tid3", "date3", "time3", "comment3", "Very Hard", "03:50", "1");
        tour.addTourLog(tourLog1);
        tour.addTourLog(tourLog2);
        tour.addTourLog(tourLog3);
        assertEquals(2, attributeService.getDifficulty(tour, "Very Hard"));
        assertEquals(1, attributeService.getDifficulty(tour, "Hard"));
    }

    @Test
    void testGetAverageRating() {
        AttributeService attributeService = new AttributeService();
        Tour tour = new Tour("id", "name", "description", "from", "to", "transporttype", 50, "time", "imagepath");
        TourLog tourLog1 = new TourLog("id", "tid", "date", "time", "comment", "Hard", "05:50", "1");
        TourLog tourLog2 = new TourLog("id", "tid2", "date2", "time2", "comment2", "Very Hard", "03:50", "5");
        TourLog tourLog3 = new TourLog("id", "tid3", "date3", "time3", "comment3", "Very Hard", "03:50", "3");
        tour.addTourLog(tourLog1);
        tour.addTourLog(tourLog2);
        tour.addTourLog(tourLog3);
        assertEquals(3, attributeService.getAverageRating(tour));
    }

    @Test
    void testGetAverageRatingWithNoTourLogs() {
        AttributeService attributeService = new AttributeService();
        Tour tour = new Tour("id", "name", "description", "from", "to", "transporttype", 50, "time", "imagepath");
        assertEquals(0, attributeService.getAverageRating(tour));
    }


}