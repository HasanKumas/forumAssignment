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

    @GetMapping("/forTopic/{topicId}")
    public List<Message> getMessageForTopic(@PathVariable("topicId") Long id) {
        if(topicRepository.existsById(id)){
        return topicRepository.getOne(id).getMessages();
        }else {
            return null;
        }
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
