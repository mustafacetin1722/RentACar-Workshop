package com.mustafa.rentAcarTwo.dataAccess.abstracts;

import com.mustafa.rentAcarTwo.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name);
}
