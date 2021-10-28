package com.example.reto3.repository;

import com.example.reto3.model.Category;
import com.example.reto3.model.Client;
import com.example.reto3.model.Reservation;
import com.example.reto3.repository.crud.CategoryCrudRepository;
import com.example.reto3.repository.crud.CrudReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private CrudReservationRepository crudReservationRepository;

    public List<Reservation> getAll(){

        return (List<Reservation>) crudReservationRepository.findAll();
    }
    public Optional<Reservation> getReservationId(int id){

        return crudReservationRepository.findById(id);
    }
    public Reservation save(Reservation r){
        return crudReservationRepository.save(r);
    }

    public void delete(Reservation m){
        crudReservationRepository.delete(m);
    }
}
