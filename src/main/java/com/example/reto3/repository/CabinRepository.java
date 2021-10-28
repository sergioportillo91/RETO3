package com.example.reto3.repository;

import com.example.reto3.model.Cabin;
import com.example.reto3.repository.crud.CabinCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CabinRepository {

    @Autowired
    private CabinCrudRepository cabinCrudRepository;

    public List<Cabin> getAll(){

        return (List<Cabin>) cabinCrudRepository.findAll();
    }
    public Optional<Cabin> getCabinId(int id){

        return cabinCrudRepository.findById(id);
    }
    public Cabin save(Cabin c){
        return cabinCrudRepository.save(c);
    }

    public void delete(Cabin c){
        cabinCrudRepository.delete(c);
    }
}

