package com.amazone.controller;

import com.amazone.service.PackageService;
import com.amazone.model.Package;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {

    @Autowired
    private PackageService service;

    @RequestMapping(method = RequestMethod.GET, value = "/package")
    public String getAllPackages() {

        Gson gson = new Gson();
        return gson.toJson(service.getPackages());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/package/{id}")
    public ResponseEntity<Package> getPackageById(@PathVariable("id") Long id) {

        Gson gson = new Gson();
        return ResponseEntity.ok(service.getPackage(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/package/{id}")
    public ResponseEntity<Package> updatePackageById(@RequestBody Package p, @PathVariable("id") Long id) {
        p.setId(id);
        p = service.update(p);
        if (p == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(p);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/package")
    public ResponseEntity<Package> updatePackageById(@RequestBody Package p) {

        p = service.save(p);
        if (p == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(p);
        }
    }

}
