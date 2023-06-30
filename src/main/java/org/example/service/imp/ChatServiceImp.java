package org.example.service.imp;

import org.example.model.Account;
import org.example.model.Chat;
import org.example.model.ChatKey;
import org.example.repository.ChatRepository;
import org.example.service.AccountService;
import org.example.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImp implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public Chat addChat(Long id1, Long id2) {
        if (accountService.existsById(id1) && accountService.existsById(id2)) {
            Account account1 = accountService.findById(id1);
            Account account2 = accountService.findById(id2);
            ChatKey chatKey1 = new ChatKey(id1, id2);
            ChatKey chatKey2 = new ChatKey(id2, id1);
            Chat chat1 = new Chat(chatKey1, account2.getName());
            Chat chat2 = new Chat(chatKey2, account1.getName());
            chatRepository.save(chat1);
            chatRepository.save(chat2);
            return chat1;
        }
        return null;
    }


    @Override
    public Chat findById(Long id1, Long id2) {
        ChatKey chatKey = new ChatKey(id1, id2);
        if (existsById(chatKey)) {
            return chatRepository.findById(chatKey).get();
        } else return null;
    }

    @Override
    public List<Chat> findAll(Long id) {
        if (accountService.existsById(id)) {
            return chatRepository.findByChatKeyId1(id);
        }
        return null;
    }

    @Override
    public void insert(Chat chat) {
        chatRepository.save(chat);
    }

    @Override
    public boolean deleteChat(Long id1, Long id2) {
        if (accountService.existsById(id1) && accountService.existsById(id2)) {
            ChatKey chatKey1 = new ChatKey(id1, id2);
            if (existsById(chatKey1)) {
                chatRepository.deleteById(chatKey1);
                return true;
            }
        }
        return false;
    }

    @Override
    public Chat findById(ChatKey chatKey) {
        if (existsById(chatKey)) {
            return chatRepository.findById(chatKey).get();
        }
        return null;
    }

    @Override
    public boolean existsById(ChatKey chatKey) {
        if (chatRepository.existsById(chatKey)) {
            return true;
        } else {
            return false;
        }
    }
}
