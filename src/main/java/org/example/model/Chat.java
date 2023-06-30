package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Chat {
    @EmbeddedId
    private ChatKey chatKey;
    @Column
    private String name;


    @Column
    private List<String> messages;

    public Chat() {
        messages = new ArrayList<>();
    }

    public Chat(ChatKey chatKey, String name) {
        this();
        this.chatKey = chatKey;
        this.name = name;
    }

    public ChatKey getChatKey() {
        return chatKey;
    }

    public void setChatKey(ChatKey chatKey) {
        this.chatKey = chatKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void addMessage(String message) {
        messages.add(message);
    }
}
