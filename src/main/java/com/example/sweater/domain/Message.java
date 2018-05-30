package com.example.sweater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
public class Message {

    @Id
    private String id;

    private String text;
    private String tag;

    public Message(){}


    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }
}