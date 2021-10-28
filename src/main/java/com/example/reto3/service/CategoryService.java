package com.example.reto3.service;

import com.example.reto3.model.Cabin;
import com.example.reto3.model.Category;
import com.example.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategoryId(int id){
        return categoryRepository.getCategoryId(id);
    }

    public Category save(Category p){
        if(p.getId()==null){
            return categoryRepository.save(p);
        }else{
            Optional<Category> paux=categoryRepository.getCategoryId(p.getId());
            if(paux.isEmpty()){
                return categoryRepository.save(p);
            }else{
                return p;
            }
        }
    }

    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category>g=categoryRepository.getCategoryId(c.getId());
            if(!g.isEmpty()){
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }if(c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }
                return categoryRepository.save(g.get());

            }
        }
        return c;

    }

    public boolean deleteCategory(int id){
        Optional<Category> c=getCategoryId(id);
        if(!c.isEmpty()){
            categoryRepository.delete(c.get());
            return true;
        }
        return false;

    }
}
