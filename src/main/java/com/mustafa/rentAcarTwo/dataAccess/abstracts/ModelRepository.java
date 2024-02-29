package com.mustafa.rentAcarTwo.dataAccess.abstracts;

import com.mustafa.rentAcarTwo.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
