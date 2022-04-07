package com.amazone.controller;

import com.amazone.model.Driver;
import com.amazone.service.DriverService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DriverController {

    @Autowired
    private DriverService service;

    @RequestMapping(method = RequestMethod.GET, value = "/driver")
    public String getAllDrivers() {

        Gson gson = new Gson();
        return gson.toJson(service.getDrivers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/driver/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable("id") Long id) {

        Gson gson = new Gson();
        return ResponseEntity.ok(service.getDriver(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/driver/{id}")
    public ResponseEntity<Driver> updateDriverById(@RequestBody Driver d, @PathVariable("id") Long id) {
        d.setId(id);
        d = service.update(d);
        if (d == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(d);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/driver")
    public ResponseEntity<Driver> updateDriverById(@RequestBody Driver d) {

        d = service.save(d);
        if (d == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(d);
        }
    }

}
