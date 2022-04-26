package swen2.tp.swen2_tp_hw.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RouteService {

    public void getRouteInformation() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://www.mapquestapi.com/directions/v2/route?key=g6R1j3Y0bqSVIOGYDGzob93YQcS4d5EJ&from=Johnstrasse,Vienna,Austria&to=Dresdnerstrasse,Vienna,Austria"))
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

        String distance = jsonNode.get("route").get("distance").asText();
        String estimatedTime = jsonNode.get("route").get("formattedTime").asText();
        String sessionid = jsonNode.get("route").get("sessionId").textValue();

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI("https://www.mapquestapi.com/staticmap/v5/map?key=g6R1j3Y0bqSVIOGYDGzob93YQcS4d5EJ&session="+sessionid+"&size=640,480&boundingBox="+lr_lat+","+lr_lng+","+ul_lat+","+ul_lng))
                .GET()
                .build()
                ;

        HttpResponse<String> response2 = null;

        response2 = HttpClient.newBuilder().build().send(request2, HttpResponse.BodyHandlers.ofString());
    }
}
