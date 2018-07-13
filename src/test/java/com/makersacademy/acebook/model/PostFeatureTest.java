package com.makersacademy.acebook.model;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import jdk.incubator.http.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class PostFeatureTest {

    @Test
    public void userPostIsStoredInDatabase() {

        // the request for making a post
        HttpRequest request = Unirest.post("http://localhost:8080/posts")
                //Accept- informs the server about the types of data that can be sent back
                .header("Accept", "application/json")
                .header("Content-Type","application/json")
                .header("token","token")
                .field("content", "Test Message")
                .field("token", "token")
                .asJson();

        HttpResponse response = Unirest.get("http://localhost:8080/posts")
                .header("Cookie","cookie")
                .asJson();
    }
}
