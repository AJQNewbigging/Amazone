package com.amazone.controller;

import com.amazone.model.Delivery;
import com.amazone.service.DeliveryService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    @RequestMapping(method = RequestMethod.GET, value = "/delivery")
    public String getAllDeliverys() {

        Gson gson = new Gson();
        return gson.toJson(service.getDeliveries());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delivery/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable("id") Long id) {

        Gson gson = new Gson();
        return ResponseEntity.ok(service.getDelivery(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/delivery/{id}")
    public ResponseEntity<Delivery> updateDeliveryById(@RequestBody Delivery d, @PathVariable("id") Long id) {
        d.setId(id);
        d = service.update(d);
        if (d == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(d);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delivery")
    public ResponseEntity<Delivery> updateDeliveryById(@RequestBody Delivery d) {

        d = service.save(d);
        if (d == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(d);
        }
    }

}
