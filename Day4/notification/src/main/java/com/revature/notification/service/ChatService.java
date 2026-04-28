package com.revature.notification.service;

import com.revature.notification.model.ChatMessage;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public ChatMessage processMessage(ChatMessage message) {
        return message;
    }
}