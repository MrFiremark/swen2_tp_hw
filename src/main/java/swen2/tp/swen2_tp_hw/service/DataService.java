package swen2.tp.swen2_tp_hw.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import swen2.tp.swen2_tp_hw.dto.JSONTour;
import swen2.tp.swen2_tp_hw.dto.JSONTourLog;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;

import java.io.*;

public class DataService {

    private ObjectMapper objectMapper = new ObjectMapper();
    private ConfigService configService = new ConfigService();

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

        Tour importedTour = null;

        try {
            FileReader reader = new FileReader("JSON_Export/Test4.json");
            JSONTour json = objectMapper.readValue(reader, JSONTour.class);
            importedTour = new Tour(json.id,json.name,json.description,json.from,json.to,json.transportType,json.distance,json.time,json.imagePath);
            for (JSONTourLog jtl : json.tourLogs
                 ) {
                importedTour.addTourLog(new TourLog(jtl.tourId, jtl.logid, jtl.date, jtl.time, jtl.comment, jtl.difficulty, jtl.totalTime, jtl.rating));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return importedTour;
    }
}
