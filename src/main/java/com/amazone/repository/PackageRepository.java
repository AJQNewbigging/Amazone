package com.amazone.repository;

import com.amazone.model.Package;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PackageRepository extends CrudRepository<Package, Long> {

    List<Package> findAll();

}
