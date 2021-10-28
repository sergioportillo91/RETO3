package com.example.reto3.repository;

import com.example.reto3.model.Cabin;
import com.example.reto3.model.Client;
import com.example.reto3.model.Message;
import com.example.reto3.repository.crud.CabinCrudRepository;
import com.example.reto3.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageRepository;

    public List<Message> getAll(){

        return (List<Message>) messageRepository.findAll();
    }
    public Optional<Message> getMessageId(int id){

        return messageRepository.findById(id);
    }
    public Message save(Message m){
        return messageRepository.save(m);
    }

    public void delete(Message m){
        messageRepository.delete(m);
    }


}
