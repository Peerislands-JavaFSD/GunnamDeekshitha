package com.revature.notification.model;

import java.time.LocalDateTime;


public class ChatMessage {

    private String sender;
    private String content;
    private String type; // JOIN, MESSAGE, LEAVE
    private LocalDateTime timestamp;

    public ChatMessage() {
        this.timestamp = LocalDateTime.now();
    }


}