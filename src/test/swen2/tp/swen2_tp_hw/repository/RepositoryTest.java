package swen2.tp.swen2_tp_hw.repository;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void testConnectionTourRepository() {
        TourRepository tourRepository = new TourRepository();
        assertNotNull(tourRepository.getConnection());
    }

    @Test
    void testConnectionLogRepository() {
        LogRepository logRepository = new LogRepository();
        assertNotNull(logRepository.getConnection());
    }

    @Test
    void testConnectionSearchRepository() {
        SearchRepository searchRepository = new SearchRepository();
        assertNotNull(searchRepository.getConnection());
    }
}