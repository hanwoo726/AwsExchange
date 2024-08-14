package com.lec.spring.handler;


import com.lec.spring.service.ChatHistoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class ChatHandler extends TextWebSocketHandler {

    private static List<WebSocketSession> list = new ArrayList<>();
    private final ChatHistoryService chatHistoryService;

    public ChatHandler(ChatHistoryService chatHistoryService) {
        this.chatHistoryService = chatHistoryService;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload" + payload);
        // 페이로드란 전송되는 데이터를 의미한다.

        String[] parts = payload.split(":");
        if(parts.length == 2){
            String username = parts[0];
            String chatMessage = parts[1];

            chatHistoryService.save(username, chatMessage);
        }

        for(WebSocketSession sess: list){
            sess.sendMessage(message);
        }

    }

    // 클라이언트가 접속 시 호출되는 메소드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        list.add(session);
        log.info(session + "클라이언트 접속");

    }


    // 클라이언트가 접속 해제 시 호추되는 메소드
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session + "클라이언트 접속 해제");
        list.remove(session);
    }
}
