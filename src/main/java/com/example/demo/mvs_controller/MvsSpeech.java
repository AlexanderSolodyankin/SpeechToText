package com.example.demo.mvs_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MvsSpeech {

    @GetMapping("/mvs/speech")
    public String getText(Model model){
        model.addAttribute("speech_text", "прочтите этот текст ");

        return "speech_text";
    }

    @PostMapping("/mvs/speech")
    public String setText(@RequestParam String speechText, Model model){
        model.addAttribute("speech_text", "Вы сказали: " + speechText );
        System.out.println(speechText);

        return "speech_text";

    }

}
