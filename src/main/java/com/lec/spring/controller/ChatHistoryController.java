package com.lec.spring.controller;

import com.lec.spring.domain.ChatHistory;
import com.lec.spring.service.ChatHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatHistoryController {

    private final ChatHistoryService chatHistoryService;


    @CrossOrigin
    @GetMapping("/chatHistory")
    public List<ChatHistory> getChatHistory(){
        return chatHistoryService.findAll();
    }
}
