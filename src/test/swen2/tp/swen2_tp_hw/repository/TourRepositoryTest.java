package swen2.tp.swen2_tp_hw.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TourRepositoryTest {

    @Test
    void addTour() {
        TourRepository tourRepository = new TourRepository();
        Tour test = new Tour(
                "12345678-1234-1234-1234-123456789012",
                "Test", "This is a UnitTest",
                "Vienna",
                "Linz",
                "Car",
                1000.0,
                "1:00:00",
                "Maps/12345678-1234-1234-1234-123456789012.png"
        );
        test.addTourLog(new TourLog(
                "12345678-1234-1234-1234-123456789012",
                "12345678-1234-1234-1234-123456789023",
                "01.01.2022",
                "00:00:00",
                "This is a UnitTest",
                "Easy",
                "02:00:00",
                "1"
        ));

    }

    @Test
    void getTours() {
    }

    @Test
    void deleteTour() {
    }

    @Test
    void updateTour() {
    }
}