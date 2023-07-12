package com.devsuperior.bds02.Repository;

import com.devsuperior.bds02.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRep extends JpaRepository<Event, Long> {
}
