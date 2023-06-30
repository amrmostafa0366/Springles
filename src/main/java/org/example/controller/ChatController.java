package org.example.controller;

import org.example.model.Chat;
import org.example.model.ChatKey;
import org.example.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;


    @PostMapping("/{id1}/{id2}")
    public ResponseEntity<Chat> addChat(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2) {
        Chat result = chatService.addChat(id1, id2);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
    @GetMapping("/{id1}/{id2}")
    public ResponseEntity<Chat> findChatById(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2) {
        Chat result = chatService.findById(id1, id2);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Chat>> findAllChats(@PathVariable("id") Long id) {
        List<Chat> result = chatService.findAll(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @DeleteMapping("/delete/{id1}/{id2}")
    public ResponseEntity<Boolean> deleteChat(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2) {
        boolean result = chatService.deleteChat(id1, id2);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
