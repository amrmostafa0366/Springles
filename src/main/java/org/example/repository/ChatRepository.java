package org.example.repository;

import org.example.model.Chat;
import org.example.model.ChatKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, ChatKey> {


    List<Chat> findByChatKeyId1(Long id);

}
