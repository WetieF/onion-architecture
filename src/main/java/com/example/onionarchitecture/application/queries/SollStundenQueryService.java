package com.example.onionarchitecture.application.queries;

import com.example.onionarchitecture.domain.sollstunden.model.BeraterSollStunden;
import com.example.onionarchitecture.domain.sollstunden.repositoryaccess.LadenSollstundenService;
import com.example.onionarchitecture.interfaces.in.rest.controller.dto.SollstundenDto;
import com.example.onionarchitecture.interfaces.repositories.DbMapper;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Sollstunden;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SollStundenQueryService {

    private LadenSollstundenService ladenSollstundenService;

    public BeraterSollStunden getBeraterSollstundenByI(Long id) {
        BeraterSollStunden beraterSollstundenById = ladenSollstundenService.getBeraterSollstundenById(id);
        return beraterSollstundenById;
    }

    public List<BeraterSollStunden> getListBeraterSollstunden() {

        List<BeraterSollStunden> listBeraterSollstunden = ladenSollstundenService.getListBeraterSollstunden();

        return listBeraterSollstunden;
    }

    /*public SollstundenDto getSomeById(Long id) {

        BeraterSollStunden someoneById = ladenSollstundenService.getSomeoneById(id);

        return DbMapper.mapBeraterSollstundenToSollstundenDto(someoneById);
    }*/
}
