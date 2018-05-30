package com.example.sweater;

import com.example.sweater.domain.Message;
import com.example.sweater.repository.MessageRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }


    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        model.put("messages", messageRepository.findAll());
        return "main";
    }

    @PostMapping("/main")
    public String add(Map<String, Object> model, @RequestParam String text, @RequestParam String tag){
       Message message = new Message(text, tag);
       messageRepository.save(message);
        List<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping ("filter")
    public String filter(Map<String, Object> model, @RequestParam @NonNull String tag){
        Iterable<Message> messages;
        if(tag !=null && !tag.isEmpty()) {
            messages = messageRepository.findByTag(tag);
        }else {
            messages=messageRepository.findAll();
        }
        model.put("messages", messages);
        return "main";
    }
}