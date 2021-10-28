package com.example.reto3.web;

import com.example.reto3.model.Cabin;
import com.example.reto3.model.Client;
import com.example.reto3.service.CabinService;
import com.example.reto3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CabinController {

    @Autowired
    private CabinService cabinService;

    @GetMapping("/all")
    public List<Cabin> getCabin(){
        return cabinService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cabin> getCabinId(@PathVariable("id") int id){
        return cabinService.getCabinId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin c){
        return cabinService.save(c);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin p){
        return cabinService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCabin(@PathVariable("id") int id){
        return cabinService.deleteCabin(id);
    }
}
