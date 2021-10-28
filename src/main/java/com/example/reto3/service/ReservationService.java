package com.example.reto3.service;

import com.example.reto3.model.Message;
import com.example.reto3.model.Reservation;
import com.example.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservationId(int id){
        return reservationRepository.getReservationId(id);
    }

    public Reservation save(Reservation m){
        if(m.getIdReservation()==null){
            return reservationRepository.save(m);
        }else{
            Optional<Reservation> paux=reservationRepository.getReservationId(m.getIdReservation());
            if(paux.isEmpty()){
                return reservationRepository.save(m);
            }else{
                return m;
            }
        }
    }

    public Reservation update(Reservation m){
        if(m.getIdReservation()!=null){
            Optional<Reservation>g=reservationRepository.getReservationId(m.getIdReservation());
            if(!g.isEmpty()){
                if(m.getDevolutionDate()!=null){
                    g.get().setDevolutionDate(m.getDevolutionDate());
                }
                return reservationRepository.save(g.get());

            }
        }
        return m;

    }

    public boolean deleteReservation(int id){
        Optional<Reservation> c=getReservationId(id);
        if(!c.isEmpty()){
            reservationRepository.delete(c.get());
            return true;
        }
        return false;

    }

}
