package ru.itis.moviehub.handlers;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

@Component
@EnableWebSocket
public class WebSocketMessagesHandler extends TextWebSocketHandler {

    private static final Map<String, WebSocketSession> sessions = new HashMap<>();

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println("handleMessage");
        for (WebSocketSession currentSession : sessions.values()) {
            currentSession.sendMessage(message);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());
    }
}
