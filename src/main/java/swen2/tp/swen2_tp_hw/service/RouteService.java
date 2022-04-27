package swen2.tp.swen2_tp_hw.service;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.image.Image;
import swen2.tp.swen2_tp_hw.dto.BoundingBox;
import swen2.tp.swen2_tp_hw.dto.Route;
import swen2.tp.swen2_tp_hw.dto.RouteResponse;
import swen2.tp.swen2_tp_hw.model.Tour;

import javax.imageio.ImageIO;

public class RouteService {

    public Tour getRouteInformation(Tour tour) throws URISyntaxException, IOException, InterruptedException {

        HttpService httpService = new HttpService();

        String url = "http://www.mapquestapi.com/directions/v2/route?key=g6R1j3Y0bqSVIOGYDGzob93YQcS4d5EJ&from="+tour.getFrom()+"&to="+tour.getTo();

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        RouteResponse routeResponse = objectMapper.readValue(httpService.handleHttpRequest(url).body(), RouteResponse.class);

        /*JsonNode jsonNode = objectMapper.readValue(httpService.handleHttpRequest(url).body(), Route.class);

        String lr_lat = jsonNode.get("route").get("boundingBox").get("lr").get("lat").asText();
        String lr_lng = jsonNode.get("route").get("boundingBox").get("lr").get("lng").asText();
        String ul_lat = jsonNode.get("route").get("boundingBox").get("ul").get("lat").asText();
        String ul_lng = jsonNode.get("route").get("boundingBox").get("ul").get("lng").asText();

        tour.setDistance(jsonNode.get("route").get("distance").asText());
        tour.setTime(jsonNode.get("route").get("formattedTime").asText());

        String sessionid = jsonNode.get("route").get("sessionId").textValue();
         */

        url = "https://www.mapquestapi.com/staticmap/v5/map?key=g6R1j3Y0bqSVIOGYDGzob93YQcS4d5EJ&session="+routeResponse.route.sessionId+"&size=640,480&boundingBox="+ BoundingBox.lr.class + "," + BoundingBox.ul.class;

        byte[] image = httpService.handleHttpRequest(url).body().getBytes();

        Image map = objectMapper.readValue(image, Image.class);

        File outputfile = new File(tour.getid()+".png");
        //ImageIO doesnt work????
        ImageIO.write((RenderedImage) map, "PNG", outputfile);

        tour.setImagePath(outputfile.getPath());
        //use response2.body() to get the picture

        return tour;
    }
}
