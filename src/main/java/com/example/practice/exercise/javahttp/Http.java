package com.example.practice.exercise.javahttp;

import com.example.practice.exercise.entity.User;
import com.example.practice.exercise.repository.JdbcUserRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public abstract class Http {

    private String url;
    public Http(String url) {
        this.url = url;
    }
    public void importFile(String data) throws IOException {
        FileWriter fileWriter=new FileWriter("D:\\internCXL\\practice\\testout.txt");
        fileWriter.write(data);
        fileWriter.close();
    }
    public  List<User> dataToList (String data) throws URISyntaxException, IOException {
        JdbcUserRepository userRepository = new JdbcUserRepository();
        List<User> userList=new ArrayList<>();
        Object object = JSONValue.parse(data); //pare json sang object
        JSONArray jsonArray = (JSONArray) object; // make to array
        for(Object key : jsonArray) {
            User user = new User();
            JSONObject jsonObject = (JSONObject) key; // make object to jsonobject
            user.setUserId(((Long) jsonObject.get("userId")).intValue());
            user.setId(((Long) jsonObject.get("id")).intValue());
            user.setTitle((String) jsonObject.get("title"));
            userRepository.saveUser(user);
            userList.add(user);
        }
        return userList;

    }

    public abstract String connect() throws IOException, URISyntaxException, InterruptedException;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}

