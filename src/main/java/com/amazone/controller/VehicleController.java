package com.amazone.controller;

import com.amazone.model.Vehicle;
import com.amazone.service.VehicleService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService service;

    @RequestMapping(method = RequestMethod.GET, value = "/vehicle")
    public String getAllVehicles() {

        Gson gson = new Gson();
        return gson.toJson(service.getVehicles());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vehicle/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") Long id) {

        Gson gson = new Gson();
        return ResponseEntity.ok(service.getVehicle(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/vehicle/{id}")
    public ResponseEntity<Vehicle> updateVehicleById(@RequestBody Vehicle v, @PathVariable("id") Long id) {
        v.setId(id);
        v = service.update(v);
        if (v == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(v);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/vehicle")
    public ResponseEntity<Vehicle> updateVehicleById(@RequestBody Vehicle v) {

        v = service.save(v);
        if (v == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(v);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/vehicle/{id}/report")
    public ResponseEntity<Vehicle> reportVehicleById(@RequestBody Vehicle v, @PathVariable("id") Long id) {
        Vehicle og = service.getVehicle(id);

        if (og == null) {
            return ResponseEntity.notFound().build();
        }
        if (v.getVCondition() != null) og.setVCondition(v.getVCondition());

        og = this.service.update(og);
        return og == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(og);
    }


}
