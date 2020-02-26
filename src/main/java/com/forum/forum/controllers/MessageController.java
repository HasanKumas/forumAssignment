package com.forum.forum.controllers;

import com.forum.forum.models.Account;
import com.forum.forum.models.Message;
import com.forum.forum.models.Topic;
import com.forum.forum.repositories.AccountRepository;
import com.forum.forum.repositories.MessageRepository;
import com.forum.forum.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/message")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;


    @GetMapping
    public List<Message> getMessage (){
        return messageRepository.findAll();
    }

    @PostMapping
    public void addMessage(@RequestBody Message message) {
        messageRepository.save(message);
    }

    @DeleteMapping("/{id}")
    void deleteMessage(@PathVariable Long id) {
        messageRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateMessage(@PathVariable("id") Long id,  @RequestBody Message message) {
        message.setId(id);
        messageRepository.save(message);
    }
}
