package com.devsuperior.bds02.controllers;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.servico.CityServico;
import com.fasterxml.jackson.databind.annotation.NoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityServico servico;

    @GetMapping
    public ResponseEntity<List<CityDTO>> get(@PageableDefault(sort = "name") Pageable p){

        Page<CityDTO> list = servico.get(p);

        return ResponseEntity.ok().body(list.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> del(@PathVariable Long id){
        servico.del(id);
        return ResponseEntity.noContent().build();
    }

}
