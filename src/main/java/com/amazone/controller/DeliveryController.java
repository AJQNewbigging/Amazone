package com.amazone.controller;

import com.amazone.model.Delivery;
import com.amazone.service.DeliveryService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    @RequestMapping(method = RequestMethod.GET, value = "/delivery")
    public ResponseEntity<List<Delivery>> getAllDeliveries() {

        return ResponseEntity.ok(service.getDeliveries());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delivery/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable("id") Long id) {

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

    @RequestMapping(method = RequestMethod.PUT, value = "/delivery/{id}/report")
    public ResponseEntity<Delivery> updateDeliveryStatus(@RequestBody Delivery d, @PathVariable("id") Long id) {

        Delivery og = service.getDelivery(id);

        if (og == null) {
            return ResponseEntity.notFound().build();
        }
        if (!d.getNotes().isEmpty()) og.setNotes(d.getNotes());
        if (d.getStatus() != null) og.setStatus(d.getStatus());

        og = this.service.update(og);
        return og == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(og);
    }

}
