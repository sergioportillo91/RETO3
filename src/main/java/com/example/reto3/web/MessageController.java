package com.example.reto3.web;

import com.example.reto3.model.Cabin;
import com.example.reto3.model.Client;
import com.example.reto3.model.Message;
import com.example.reto3.service.ClientService;
import com.example.reto3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getClient(){
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getClientId(@PathVariable("id") int id){
        return messageService.getMessageId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message m){
        return messageService.save(m);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message p){
        return messageService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMessage(@PathVariable("id") int id){
        return messageService.deleteMessage(id);
    }
}
