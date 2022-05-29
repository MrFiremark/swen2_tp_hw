package swen2.tp.swen2_tp_hw.service;

import org.junit.jupiter.api.Test;
import swen2.tp.swen2_tp_hw.model.Tour;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RouteServiceTest {

    @Test
    void testGetCarRouteInformation() throws URISyntaxException, IOException, InterruptedException {
        RouteService routeService = new RouteService();
        Tour testSucess = new Tour(UUID.randomUUID().toString(), "UnitTest", "This is a UnitTest", "Vienna", "Linz", "Car");
        testSucess = routeService.getRouteInformation(testSucess);
        assertEquals(testSucess.getTime(), "01:45:40");
        assertEquals(testSucess.getDistance(), 113.913);
    }

    @Test
    void testGetBikeRouteInformation() throws URISyntaxException, IOException, InterruptedException {
        RouteService routeService = new RouteService();
        Tour testSucess = new Tour(UUID.randomUUID().toString(), "UnitTest", "This is a UnitTest", "Vienna", "Linz", "Bike");
        testSucess = routeService.getRouteInformation(testSucess);
        assertNotNull(testSucess.getTime());
        assertEquals(testSucess.getTime(), "09:37:43");
        assertEquals(testSucess.getDistance(), 137.066);
    }

    @Test
    void testGetWalkRouteInformation() throws URISyntaxException, IOException, InterruptedException {
        RouteService routeService = new RouteService();
        Tour testSucess = new Tour(UUID.randomUUID().toString(), "UnitTest", "This is a UnitTest", "Vienna", "Linz", "Walk");
        testSucess = routeService.getRouteInformation(testSucess);
        assertNotNull(testSucess.getTime());
        assertEquals(testSucess.getTime(), "45:30:10");
        assertEquals(testSucess.getDistance(), 113.759);
    }

    @Test
    void testFailGetRouteInformation() throws URISyntaxException, IOException, InterruptedException {
        RouteService routeService = new RouteService();
        Tour testFail = new Tour(UUID.randomUUID().toString(), "UnitTest", "This is a UnitTest", "dawdawda", "dwadawdaw", "Car");
        testFail = routeService.getRouteInformation(testFail);
        assertNull(routeService.getRouteInformation(testFail).getTime());
        assertEquals(testFail.getDistance(), 0.0);
    }
}