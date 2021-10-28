package com.example.reto3.service;

import com.example.reto3.model.Category;
import com.example.reto3.model.Client;
import com.example.reto3.model.Message;
import com.example.reto3.repository.CategoryRepository;
import com.example.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessageId(int id){
        return messageRepository.getMessageId(id);
    }

    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            Optional<Message> paux=messageRepository.getMessageId(m.getIdMessage());
            if(paux.isEmpty()){
                return messageRepository.save(m);
            }else{
                return m;
            }
        }
    }

    public Message update(Message m){
        if(m.getIdMessage()!=null){
            Optional<Message>g=messageRepository.getMessageId(m.getIdMessage());
            if(!g.isEmpty()){
                if(m.getMessageText()!=null){
                    g.get().setMessageText(m.getMessageText());
                }
                return messageRepository.save(g.get());

            }
        }
        return m;

    }

    public boolean deleteMessage(int id){
        Optional<Message> c=getMessageId(id);
        if(!c.isEmpty()){
            messageRepository.delete(c.get());
            return true;
        }
        return false;

    }
}
