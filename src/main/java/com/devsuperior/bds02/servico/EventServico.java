package com.devsuperior.bds02.servico;

import com.devsuperior.bds02.Infra.exception.ResourceNotFoundException;
import com.devsuperior.bds02.Repository.CityRep;
import com.devsuperior.bds02.Repository.EventRep;
import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.time.LocalDate;

@Service
public class EventServico {

    @Autowired
    private EventRep rep;
    @Autowired
    private CityRep cityRep;

    public Event update(Long id, EventDTO dto){
        try {
            Event event = aVoid(id, dto);
            rep.save(event);
            return event;
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("");
        }

    }

    private Event aVoid(Long id, EventDTO dto){
        City city = cityRep.getOne(dto.getCityId());
        Event event = rep.getOne(id);

        event.setCity(city);
        event.setDate(dto.getDate());
        event.setName(dto.getName());
        event.setUrl(dto.getUrl());
        return event;
    }
}
