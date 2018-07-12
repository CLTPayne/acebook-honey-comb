package com.makersacademy.acebook.model;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class PostFeatureTest {

    @Test
    public void userPostIsStoredInDatabase() {

        HttpResponse<JsonNode> jsonResponse = Unirest.post("http://localhost:8080/posts")
                .header("accept", "application/json")
                // do we have the token in the query string? Do we need a test token here
                .queryString("apiKey", "123")

                .field("content", "Test Message")
                // do we need to have any extra fields?
                .field("foo", "bar")
                .asJson();

//    Unirest.shutdown();


        assertThat(post.getContent(), containsString("hello"));
    }

}
