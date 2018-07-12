package com.makersacademy.acebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Timestamp time_created;
    private Long user_id;

    private Post() {}

    public Post(String content, Long user_id) {
        this.content = content;
        this.user_id = user_id;
    }

    public String thecontent(){
        return this.content;
    }


}
