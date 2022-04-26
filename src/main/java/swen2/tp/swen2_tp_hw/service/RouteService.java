package swen2.tp.swen2_tp_hw.service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.image.Image;
import swen2.tp.swen2_tp_hw.model.Tour;

public class RouteService {

    public Tour getRouteInformation(Tour tour) throws URISyntaxException, IOException, InterruptedException {

        String fromtest = "Johnstrasse,Vienna,Austria";
        String totest = "Dresdnerstrasse,Vienna,Austria";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://www.mapquestapi.com/directions/v2/route?key=g6R1j3Y0bqSVIOGYDGzob93YQcS4d5EJ&from="+fromtest+"&to="+totest))
                .GET()
                .build()
                ;

        HttpResponse<String> response = null;

        response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(json);

        String lr_lat = jsonNode.get("route").get("boundingBox").get("lr").get("lat").asText();
        String lr_lng = jsonNode.get("route").get("boundingBox").get("lr").get("lng").asText();
        String ul_lat = jsonNode.get("route").get("boundingBox").get("ul").get("lat").asText();
        String ul_lng = jsonNode.get("route").get("boundingBox").get("ul").get("lng").asText();

        tour.setDistance(jsonNode.get("route").get("distance").asText());
        tour.setTime(jsonNode.get("route").get("formattedTime").asText());

        String sessionid = jsonNode.get("route").get("sessionId").textValue();

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI("https://www.mapquestapi.com/staticmap/v5/map?key=g6R1j3Y0bqSVIOGYDGzob93YQcS4d5EJ&session="+sessionid+"&size=640,480&boundingBox="+lr_lat+","+lr_lng+","+ul_lat+","+ul_lng))
                .GET()
                .build()
                ;

        HttpResponse<String> response2 = null;

        response2 = HttpClient.newBuilder().build().send(request2, HttpResponse.BodyHandlers.ofString());

        System.out.println(response2);

        byte[] image = response2.body().getBytes();

        ObjectMapper objectMapper1 = new ObjectMapper();

        Image map = objectMapper1.readValue(image, Image.class);

        File outputfile = new File("Map.png");
        //ImageIO doesnt work????

        //use response2.body() to get the picture

        return tour;
    }
}
