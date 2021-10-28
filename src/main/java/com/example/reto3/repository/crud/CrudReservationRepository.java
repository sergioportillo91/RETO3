package com.example.reto3.repository.crud;

import com.example.reto3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface CrudReservationRepository extends CrudRepository<Reservation,Integer> {
}
