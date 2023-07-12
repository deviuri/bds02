package com.devsuperior.bds02.servico;

import com.devsuperior.bds02.Infra.exception.DatabaseException;
import com.devsuperior.bds02.Infra.exception.ResourceNotFoundException;
import com.devsuperior.bds02.Infra.exception.NoSuchElementException;
import com.devsuperior.bds02.Repository.CityRep;
import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;


@Service
public class CityServico {

    @Autowired
    private CityRep rep;

    public Page<CityDTO> get(Pageable p) {
        Page<City> cities = rep.findAll(p);

        return cities.map(CityDTO::new);
    }

    public void del(Long id) {
        try {
            City city = rep.findById(id).get();
            rep.delete(city);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Item do id: " + id + " não foi encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Não encontrado");
        }
    }


}
