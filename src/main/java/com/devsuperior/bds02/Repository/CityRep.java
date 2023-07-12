package com.devsuperior.bds02.Repository;

import com.devsuperior.bds02.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRep extends JpaRepository<City, Long> {
}
