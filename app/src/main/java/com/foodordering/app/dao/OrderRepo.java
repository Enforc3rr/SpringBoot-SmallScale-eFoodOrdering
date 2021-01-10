package com.foodordering.app.dao;

import com.foodordering.app.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<OrderEntity,Long> {
}
