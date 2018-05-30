package com.example.sweater.repository;

import java.util.List;

import com.example.sweater.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByTag(String tag);
}