package com.foodordering.app.dao;

import com.foodordering.app.entity.DishEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepo extends CrudRepository<DishEntity,Long> {
    @Override
    List<DishEntity> findAll();
}
