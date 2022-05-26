package swen2.tp.swen2_tp_hw.service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import swen2.tp.swen2_tp_hw.dto.TourDTO;
import swen2.tp.swen2_tp_hw.dto.TourLogDTO;
import swen2.tp.swen2_tp_hw.mapper.Mapper;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;

import java.io.*;

public class DataService {

    private ObjectMapper objectMapper = new ObjectMapper();
    private ConfigService configService = new ConfigService();
    private Mapper mapper = new Mapper();

    public void exportTour(Tour tour){
        String path = configService.load("directory.export");
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(tour);
            System.out.println(json);
            PrintWriter out = new PrintWriter(new FileWriter(path + tour.getName() + ".json"));
            out.write(json);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Tour importTour(){

        TourDTO tourDTO = null;

        try {
            FileReader reader = new FileReader("JSON_Export/Test4.json");
            tourDTO = objectMapper.readValue(reader, TourDTO.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapper.toUser(tourDTO);
    }
}
