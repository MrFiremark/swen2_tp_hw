package swen2.tp.swen2_tp_hw.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigServiceTest {

    @Test
    void testWrongKey(){
        String url = "Hello";
        ConfigService configService = new ConfigService();
        String result = configService.load(url);
        assertNull(result);
    }

    @Test
    void testLoadUrl() {
        String url = "db.url.test";
        ConfigService configService = new ConfigService();
        String result = configService.load(url);
        assertEquals("Test", result);
    }

    @Test
    void testLoadUser(){
        String url = "db.user.test";
        ConfigService configService = new ConfigService();
        String result = configService.load(url);
        assertEquals("User", result);
    }
    @Test
    void testLoadPassword(){
        String url = "db.pw.test";
        ConfigService configService = new ConfigService();
        String result = configService.load(url);
        assertEquals("Password", result);
    }

    @Test
    void testLoadMapApiKey(){
        String url = "mapapi.key";
        ConfigService configService = new ConfigService();
        String result = configService.load(url);
        assertEquals("g6R1j3Y0bqSVIOGYDGzob93YQcS4d5EJ", result);
    }

    @Test
    void testLoadPdfDirectory(){
        String url = "directory.pdf";
        ConfigService configService = new ConfigService();
        String result = configService.load(url);
        assertEquals("Reports/", result);
    }

    @Test
    void testLoadMapsDirectory(){
        String url = "directory.maps";
        ConfigService configService = new ConfigService();
        String result = configService.load(url);
        assertEquals("Maps/", result);
    }



}