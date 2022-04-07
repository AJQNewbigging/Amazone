package com.amazone.service;

import com.amazone.model.Delivery;
import com.amazone.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository repo;

    public List<Delivery> getDeliveries() {
        return this.repo.findAll();
    }

    public Delivery getDelivery(Long id) {
        Optional<Delivery> opt = this.repo.findById(id);

        return opt.orElse(null);
    }

    public Delivery update(Delivery d) {
        return this.repo.save(d);
    }

    public Delivery save(Delivery d) {
        return this.repo.save(d);
    }

}
