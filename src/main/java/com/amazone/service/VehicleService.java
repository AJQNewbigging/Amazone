package com.amazone.service;

import com.amazone.model.Vehicle;
import com.amazone.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repo;

    public List<Vehicle
            > getVehicles() {
        return this.repo.findAll();
    }

    public Vehicle getVehicle(Long id) {
        Optional<Vehicle> opt = this.repo.findById(id);

        return opt.orElse(null);
    }

    public Vehicle update(Vehicle v) {
        return this.repo.save(v);
    }

    public Vehicle save(Vehicle v) {
        return this.repo.save(v);
    }

}
