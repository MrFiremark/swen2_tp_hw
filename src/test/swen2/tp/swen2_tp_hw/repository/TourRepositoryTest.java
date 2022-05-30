package swen2.tp.swen2_tp_hw.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
                "12345678-1234-1234-1234-123456789031",
                "01.01.2022",
                "00:00:00",
                "This is a UnitTest",
                "Easy",
                "02:00:00",
                "1"
        ));
        tourRepository.addTour(test);
        assertEquals("Test", tourRepository.getTours().get("12345678-1234-1234-1234-123456789012").getName());
        tourRepository.deleteTour(test);
    }

    @Test
    void getTours() {
        TourRepository tourRepository = new TourRepository();
        Tour test1 = new Tour(
                "12345678-1234-1234-1234-123456789013",
                "Test", "This is a UnitTest",
                "Vienna",
                "Linz",
                "Car",
                1000.0,
                "1:00:00",
                "Maps/12345678-1234-1234-1234-123456789013.png"
        );
        test1.addTourLog(new TourLog(
                "12345678-1234-1234-1234-123456789013",
                "12345678-1234-1234-1234-123456789032",
                "01.01.2022",
                "00:00:00",
                "This is a UnitTest",
                "Easy",
                "02:00:00",
                "1"
        ));
        Tour test2 = new Tour(
                "12345678-1234-1234-1234-123456789023",
                "Test2", "This is a UnitTest",
                "Vienna",
                "Linz",
                "Car",
                1000.0,
                "1:00:00",
                "Maps/12345678-1234-1234-1234-123456789023.png"
        );
        test1.addTourLog(new TourLog(
                "12345678-1234-1234-1234-123456789023",
                "12345678-1234-1234-1234-123456789033",
                "01.01.2022",
                "00:00:00",
                "This is a UnitTest",
                "Easy",
                "02:00:00",
                "1"
        ));
        tourRepository.addTour(test1);
        tourRepository.addTour(test2);
        assertEquals("Test", tourRepository.getTours().get("12345678-1234-1234-1234-123456789013").getName());
        assertEquals("Test2", tourRepository.getTours().get("12345678-1234-1234-1234-123456789023").getName());
        tourRepository.deleteTour(test1);
        tourRepository.deleteTour(test2);
    }

    @Test
    void deleteTour() {
        TourRepository tourRepository = new TourRepository();
        Tour test = new Tour(
                "12345678-1234-1234-1234-123456789014",
                "Test", "This is a UnitTest",
                "Vienna",
                "Linz",
                "Car",
                1000.0,
                "1:00:00",
                "Maps/12345678-1234-1234-1234-123456789014.png"
        );
        test.addTourLog(new TourLog(
                "12345678-1234-1234-1234-123456789014",
                "12345678-1234-1234-1234-123456789034",
                "01.01.2022",
                "00:00:00",
                "This is a UnitTest",
                "Easy",
                "02:00:00",
                "1"
        ));
        tourRepository.addTour(test);
        assertEquals("Test", tourRepository.getTours().get("12345678-1234-1234-1234-123456789014").getName());
        tourRepository.deleteTour(test);
        assertEquals(0, tourRepository.getTours().size());

    }

    @Test
    void updateTour() {
        TourRepository tourRepository = new TourRepository();
        Tour test = new Tour(
                "12345678-1234-1234-1234-123456789015",
                "Test", "This is a UnitTest",
                "Vienna",
                "Linz",
                "Car",
                1000.0,
                "1:00:00",
                "Maps/12345678-1234-1234-1234-123456789015.png"
        );
        test.addTourLog(new TourLog(
                "12345678-1234-1234-1234-123456789015",
                "12345678-1234-1234-1234-123456789035",
                "01.01.2022",
                "00:00:00",
                "This is a UnitTest",
                "Easy",
                "02:00:00",
                "1"
        ));
        tourRepository.addTour(test);
        test.setName("Changed");
        tourRepository.updateTour(test);
        assertEquals("Changed", tourRepository.getTours().get("12345678-1234-1234-1234-123456789015").getName());
        tourRepository.deleteTour(test);
    }
}