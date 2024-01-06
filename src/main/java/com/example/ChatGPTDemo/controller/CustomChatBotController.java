package com.example.ChatGPTDemo.controller;

import com.example.ChatGPTDemo.model.ChatGptRequest;
import com.example.ChatGPTDemo.model.ChatGptResponse;
import com.example.ChatGPTDemo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomChatBotController {

    @Autowired
    private RestTemplate template;

    String chatGptUrl = "https://api.openai.com/v1/chat/completions";

    String chatGptModel = "gpt-3.5-turbo";

    @GetMapping("/bot/{message}")
    public ChatGptResponse getChatGptResponse(@PathVariable("message") String message){

        ChatGptRequest request = new ChatGptRequest();
        List<Message> messageList = new ArrayList<>();
        Message chatGptMessage = new Message();
        chatGptMessage.setRole("user");
        chatGptMessage.setContent(message);
        messageList.add(chatGptMessage);
        request.setModel(chatGptModel);
        request.setMessages(messageList);

        ChatGptResponse chatGptResponse = template.postForObject(chatGptUrl, request,ChatGptResponse.class);
        return chatGptResponse;
    }
}
