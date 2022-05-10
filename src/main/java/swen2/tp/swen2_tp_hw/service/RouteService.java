package swen2.tp.swen2_tp_hw.service;

import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
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

    private ConfigService configService= new ConfigService();

    public Tour getRouteInformation(Tour tour) throws URISyntaxException, IOException, InterruptedException {

        HttpService httpService = new HttpService();

        String apikey = configService.load("mapapi.key");

        String url = "http://www.mapquestapi.com/directions/v2/route?key="+apikey+"&from="+tour.getFrom()+"&to="+tour.getTo();

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        RouteResponse routeResponse = objectMapper.readValue(httpService.handleHttpRequest(url).body(), RouteResponse.class);

        tour.setDistance(routeResponse.route.getDistance());
        tour.setTime(routeResponse.route.getFormattedTime());

        url = "https://www.mapquestapi.com/staticmap/v5/map?key="+apikey+"&" +
                "session=" + routeResponse.route.sessionId + "&" +
                "size=640,480&" +
                "boundingBox=" + routeResponse.route.boundingBox.lr.lat + "," + routeResponse.route.boundingBox.lr.lng + "," + routeResponse.route.boundingBox.ul.lat + "," + routeResponse.route.boundingBox.ul.lng;

        byte[] image = httpService.handleHttpRequestImage(url).body();
        File outputfile = new File(configService.load("directory.maps") + tour.getid() + ".png");
        FileOutputStream fileOutputStream = new FileOutputStream(outputfile);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                //ImageIO.write(ImageIO.read(new ByteArrayInputStream(image)), "PNG", outputfile);

                try {
                    fileOutputStream.write(image);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                tour.setImagePath(outputfile.getPath());
            }
        });
        thread.start();
        thread.sleep(2000);
        return tour;
    }
}
