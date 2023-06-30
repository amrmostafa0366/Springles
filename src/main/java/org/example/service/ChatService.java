package org.example.service;

import org.example.model.Chat;
import org.example.model.ChatKey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatService {

    Chat findById(Long id1, Long id2);


    boolean deleteChat(Long id1, Long id2);

    Chat findById(ChatKey chatKey);

    boolean existsById(ChatKey chatKey);

    Chat addChat(Long id1, Long id2);

    List<Chat> findAll(Long id);

    void insert(Chat chat1);
}
