package com.amazone.service;

import com.amazone.model.Driver;
import com.amazone.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repo;

    public List<Driver> getDrivers() {
        return this.repo.findAll();
    }

    public Driver getDriver(Long id) {
        Optional<Driver> opt = this.repo.findById(id);

        return opt.orElse(null);
    }

    public Driver update(Driver d) {
        return this.repo.save(d);
    }

    public Driver save(Driver d) {
        return this.repo.save(d);
    }

}
