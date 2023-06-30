package org.example.service;

import org.example.model.Account;
import org.example.model.Chat;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    Account insert(Account account);

    Chat sendMessage(Long id1, Long id2, String message);

    boolean existsById(Long id);

    Account findById(Long id1);
}
