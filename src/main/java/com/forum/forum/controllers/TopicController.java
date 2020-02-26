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
@RequestMapping("api/topic")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/forTopic/{accountId}")
    public List<Message> getMessageForTopic(@PathVariable("id") Long id) {
        List<Message> foundMessages = new ArrayList<Message>();

        for (Message message : messageRepository.findAll()) {
            if (message.getId().equals(id)) {
                foundMessages.add(message);
            }
        }
        return foundMessages;
    }

    @GetMapping
    public List<Topic> getTopic (){
        return topicRepository.findAll();
    }

    @PostMapping
    public void addTopic(@RequestBody Topic topic) {
        topicRepository.save(topic);
    }

    @DeleteMapping("/{id}")
    void deleteTopic(@PathVariable Long id) {
        topicRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateTopic(@PathVariable("id") Long id,  @RequestBody Topic topic) {
        topic.setId(id);
        topicRepository.save(topic);
    }
}
