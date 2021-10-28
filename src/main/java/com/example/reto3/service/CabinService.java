package com.example.reto3.service;

import com.example.reto3.model.Cabin;
import com.example.reto3.model.Category;
import com.example.reto3.repository.CabinRepository;
import com.example.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabinService {

    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getAll(){
        return cabinRepository.getAll();
    }
    public Optional<Cabin> getCabinId(int id){
        return cabinRepository.getCabinId(id);
    }

    public Cabin save(Cabin c){
        if(c.getId()==null){
            return cabinRepository.save(c);
        }else{
            Optional<Cabin> paux=cabinRepository.getCabinId(c.getId());
            if(paux.isEmpty()){
                return cabinRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Cabin update(Cabin c){
        if(c.getId()!=null){
            Optional<Cabin>g=cabinRepository.getCabinId(c.getId());
            if(!g.isEmpty()){
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }if(c.getBrand()!=null){
                    g.get().setBrand(c.getBrand());
                }if(c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }if(c.getRooms()!=0){
                    g.get().setRooms(c.getRooms());
                }
                return cabinRepository.save(g.get());

            }
        }
        return c;

    }

    public boolean deleteCabin(int id){
        Optional<Cabin> c=getCabinId(id);
        if(!c.isEmpty()){
            cabinRepository.delete(c.get());
            return true;
        }
        return false;

    }
}


