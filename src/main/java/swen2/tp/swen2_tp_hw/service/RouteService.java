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
import java.util.Arrays;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.image.Image;
import swen2.tp.swen2_tp_hw.dto.BoundingBox;
import swen2.tp.swen2_tp_hw.dto.Route;
import swen2.tp.swen2_tp_hw.dto.RouteResponse;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.wrapper.ILoggerWrapper;
import swen2.tp.swen2_tp_hw.wrapper.LoggerFactory;

import javax.imageio.ImageIO;

public class RouteService {

    private final ConfigService configService= new ConfigService();
    private final ILoggerWrapper logger = LoggerFactory.getLogger();

    public Tour getRouteInformation(Tour tour) throws URISyntaxException, IOException, InterruptedException {

        HttpService httpService = new HttpService();

        String apikey = configService.load("mapapi.key");
        String url;

        if(tour.getTransportType().equals("Walk")) {
            url = "http://www.mapquestapi.com/directions/v2/route?key=" + apikey + "&from=" + tour.getFrom() + "&to=" + tour.getTo() + "&routeType=pedestrian";
        }else if(tour.getTransportType().equals("Bike")){
            url = "http://www.mapquestapi.com/directions/v2/route?key=" + apikey + "&from=" + tour.getFrom() + "&to=" + tour.getTo() + "&routeType=bicycle";
        }else{
            url = "http://www.mapquestapi.com/directions/v2/route?key=" + apikey + "&from=" + tour.getFrom() + "&to=" + tour.getTo();
        }

        System.out.println(url);

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        RouteResponse routeResponse = objectMapper.readValue(httpService.handleHttpRequest(url).body(), RouteResponse.class);

        if(routeResponse.info.statuscode == 0){

            tour.setDistance(routeResponse.route.distance);
            tour.setTime(routeResponse.route.formattedTime);

            url = "https://www.mapquestapi.com/staticmap/v5/map?key="+apikey+"&" +
                    "session=" + routeResponse.route.sessionId + "&" +
                    "size=640,480&" +
                    "boundingBox=" + routeResponse.route.boundingBox.lr.lat + "," + routeResponse.route.boundingBox.lr.lng + "," + routeResponse.route.boundingBox.ul.lat + "," + routeResponse.route.boundingBox.ul.lng;

            byte[] image = httpService.handleHttpRequestImage(url).body();
            File outputfile = new File(configService.load("directory.maps") + tour.getid() + ".png");
            FileOutputStream fileOutputStream = new FileOutputStream(outputfile);

            Thread thread = new Thread(() -> {
                try {
                    fileOutputStream.write(image);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tour.setImagePath(outputfile.getPath());
            });

            thread.start();

        }else{
            logger.error("API error [err:" + routeResponse.info.statuscode + "]. API message: " + Arrays.toString(routeResponse.info.messages));
        }

        return tour;
    }
}
