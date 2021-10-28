package com.example.reto3.repository.crud;

import com.example.reto3.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CategoryCrudRepository extends CrudRepository<Category,Integer> {
}
