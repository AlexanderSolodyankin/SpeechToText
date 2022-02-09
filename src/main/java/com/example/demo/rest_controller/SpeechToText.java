package com.example.demo.rest_controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeechToText {

    @GetMapping("/api/speech")
    public String getText(){
        return "Прочтите это предложение";
    }

}
