package org.example.controller;

import org.example.model.Account;
import org.example.model.Chat;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        Account result = accountService.insert(account);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @PostMapping("/send-message/{id1}/{id2}")
    public ResponseEntity<Chat> sendMessage(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2, @RequestParam("message") String message) {
        Chat result = accountService.sendMessage(id1, id2, message);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

}
