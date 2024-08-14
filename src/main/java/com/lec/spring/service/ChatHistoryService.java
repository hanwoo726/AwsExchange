package com.lec.spring.service;

import com.lec.spring.domain.ChatHistory;
import com.lec.spring.repository.ChatHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatHistoryService {
    private final ChatHistoryRepository chatHistoryRepository;

    public ChatHistoryService(ChatHistoryRepository chatHistoryRepository) {
        this.chatHistoryRepository = chatHistoryRepository;
    }

    public ChatHistory save(String username, String message){
        ChatHistory chatHistory = new ChatHistory(username, message, LocalDateTime.now());
        return chatHistoryRepository.save(chatHistory);
    }

    public List<ChatHistory> findAll() {
        return chatHistoryRepository.findAll();
    }


}
