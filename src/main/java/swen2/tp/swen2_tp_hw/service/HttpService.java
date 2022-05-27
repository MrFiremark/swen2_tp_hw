package swen2.tp.swen2_tp_hw.service;

import swen2.tp.swen2_tp_hw.wrapper.ILoggerWrapper;
import swen2.tp.swen2_tp_hw.wrapper.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpService {

    private ILoggerWrapper logger = LoggerFactory.getLogger();

    public HttpResponse<String> handleHttpRequest(String url) throws IOException, InterruptedException, URISyntaxException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build()
                ;

        HttpResponse<String> response;

        response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() >= 400){
            logger.error("HTTP error [err:" + response.statusCode() + "]. Could not retrieve route information.");
        }

        return response;
    }

    public HttpResponse<byte[]> handleHttpRequestImage(String url) throws IOException, InterruptedException, URISyntaxException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build()
                ;

        HttpResponse<byte[]> response;

        response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofByteArray());
        if(response.statusCode() >= 400){
            logger.error("HTTP error [err:" + response.statusCode() + "]. Could not retrieve map information.");
        }
        return response;
    }
}
