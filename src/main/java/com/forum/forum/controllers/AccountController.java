package com.forum.forum.controllers;

import com.forum.forum.models.Account;
import com.forum.forum.models.Message;
import com.forum.forum.repositories.AccountRepository;
import com.forum.forum.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/forAccount/{accountId}")
    public List<Message> getMessageForAccount(@PathVariable("accountId") Long id) {
        if(accountRepository.existsById(id)) {
            return accountRepository.getOne(id).getMessages();
        }else{
        return  null;}
    }

        @GetMapping
        public List<Account> getAccount () {
            return accountRepository.findAll();
        }

        @PostMapping
        public void addAccount (@RequestBody Account account){
            accountRepository.save(account);
        }

        @DeleteMapping("/{id}")
        void deleteAccount (@PathVariable Long id){
            accountRepository.deleteById(id);
        }

        @PutMapping("/{id}")
        public void updateAccount (@PathVariable("id") Long id, @RequestBody Account account){
            account.setId(id);
            accountRepository.save(account);
        }

}
