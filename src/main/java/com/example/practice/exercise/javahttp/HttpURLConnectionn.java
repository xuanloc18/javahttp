package com.example.practice.exercise.javahttp;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionn extends Http{
    public HttpURLConnectionn(String url) {
        super(url);
    }
    @Override
    public String connect() throws IOException {
        URL url1 = new URL(getUrl());
        HttpURLConnection con = (HttpURLConnection) url1.openConnection();
        con.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine).append("\n");
        }
        br.close();
        con.disconnect();
        return response.toString();
    }

}
