package com.example.reto3.service;

import com.example.reto3.model.Message;
import com.example.reto3.model.Reservation;
import com.example.reto3.model.custom.ContadorClientes;
import com.example.reto3.model.custom.StatusReservas;
import com.example.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public StatusReservas reporteStatusServicio (){
        List<Reservation>completed= reservationRepository.ReservationStatus("completed");
        List<Reservation>cancelled= reservationRepository.ReservationStatus("cancelled");

        return new StatusReservas(completed.size(), cancelled.size() );
    }

    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();

        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepository.ReservationTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();

        }
    }

    public List<ContadorClientes> reporteClientesServicio(){
        return reservationRepository.getClientesRepositorio();
    }

}
