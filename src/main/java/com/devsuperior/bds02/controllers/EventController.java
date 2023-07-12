package com.devsuperior.bds02.controllers;

import com.devsuperior.bds02.Repository.EventRep;
import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.servico.EventServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventServico servico;

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> up(@PathVariable Long id, @RequestBody EventDTO dto){
        Event event = servico.update(id, dto);

        return ResponseEntity.ok().body(new EventDTO(event));
    }
}
