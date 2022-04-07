package com.amazone.repository;

import com.amazone.model.Delivery;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

    List<Delivery> findAll();

}
