package org.example.service.imp;

import jakarta.transaction.Transactional;
import org.example.model.Account;
import org.example.model.Chat;
import org.example.model.ChatKey;
import org.example.repository.AccountRepository;
import org.example.service.AccountService;
import org.example.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Lazy
    @Autowired
    private ChatService chatService;

    @Override
    public Account insert(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).get();
    }
    @Transactional
    @Override
    public Chat sendMessage(Long id1, Long id2, String message) {
        if (existsById(id1) && existsById(id2)) {
            ChatKey chatKey1 = new ChatKey(id1, id2);
            ChatKey chatKey2 = new ChatKey(id2, id1);
            Account account1 = accountRepository.findById(id1).get();
            Account account2 = accountRepository.findById(id2).get();

            boolean chatKey1Exists = chatService.existsById(chatKey1);
            boolean chatKey2Exists = chatService.existsById(chatKey2);

            Chat chat1;
            Chat chat2;

            if (chatKey1Exists && chatKey2Exists) {
                chat1 = chatService.findById(chatKey1);
                chat2 = chatService.findById(chatKey2);
            } else if (chatKey1Exists) {
                chat1 = chatService.findById(chatKey1);
                chat2 = new Chat(chatKey2, account1.getName());
            } else if (chatKey2Exists) {
                chat1 = new Chat(chatKey1, account2.getName());
                chat2 = chatService.findById(chatKey2);
            } else {
                chat1 = new Chat(chatKey1, account2.getName());
                chat2 = new Chat(chatKey2, account1.getName());
            }

            chat1.addMessage(message);
            chat2.addMessage(message);

            chatService.insert(chat1);
            chatService.insert(chat2);

            return chat1;
        }

        return null;
    }


    @Override
    public boolean existsById(Long id) {
        return accountRepository.existsById(id);
    }

}
