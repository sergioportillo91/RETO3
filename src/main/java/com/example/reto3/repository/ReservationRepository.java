package com.example.reto3.repository;

import com.example.reto3.model.Category;
import com.example.reto3.model.Client;
import com.example.reto3.model.Reservation;
import com.example.reto3.model.custom.ContadorClientes;
import com.example.reto3.repository.crud.CategoryCrudRepository;
import com.example.reto3.repository.crud.CrudReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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

    public List<Reservation>ReservationStatus(String status){
        return crudReservationRepository.findAllByStatus(status);
    }

    public List<Reservation> ReservationTiempoRepositorio(Date a, Date b){
        return crudReservationRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<ContadorClientes> getClientesRepositorio(){
        List<ContadorClientes> res =new ArrayList<>();
        List<Object[]> report = crudReservationRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new ContadorClientes((long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }

}
