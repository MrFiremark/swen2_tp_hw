package swen2.tp.swen2_tp_hw.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpService {

    public HttpResponse<String> handleHttpRequest(String url) throws IOException, InterruptedException, URISyntaxException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build()
                ;

        HttpResponse<String> response = null;

        response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }
}
