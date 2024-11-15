package com.example.practice.exercise.javahttp;

import com.example.practice.exercise.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/albums";
//        Http http=new HttpURLConnectionn(url);
//        System.out.println(http.connect());
//        http.importFile(http.connect());
        Http http1=new HttpClientDemo(url);
        http1.setUrl(url);
        System.out.println(http1.connect());
        List<User> users=http1.dataToList(http1.connect());
        users.forEach(System.out::println);
    }
}
