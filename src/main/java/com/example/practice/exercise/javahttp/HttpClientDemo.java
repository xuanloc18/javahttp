package com.example.practice.exercise.javahttp;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientDemo extends Http{

    public HttpClientDemo(String url) {
        super(url);
    }
    @Override
    public String connect() throws IOException, URISyntaxException, InterruptedException {
        URL url =new URL(getUrl());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest= HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .GET()
                .uri(url.toURI())
                .build();
        HttpResponse<String> response=client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
