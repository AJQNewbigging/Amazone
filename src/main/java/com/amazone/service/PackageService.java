package com.amazone.service;

import com.amazone.model.Package;
import com.amazone.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService {

    @Autowired
    private PackageRepository repo;

    public List<Package> getPackages() {
        return this.repo.findAll();
    }

    public Package getPackage(Long id) {
        Optional<Package> optPackage = this.repo.findById(id);

        return optPackage.orElse(null);
    }

    public Package update(Package p) {
        return this.repo.save(p);
    }

    public Package save(Package p) {
        return this.repo.save(p);
    }

}
