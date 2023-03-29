package com.example.onionarchitecture.application.commands;

import com.example.onionarchitecture.domain.sollstunden.SollstundenService;
import com.example.onionarchitecture.domain.sollstunden.command.DeleteSollstundenCommand;
import com.example.onionarchitecture.domain.sollstunden.command.SollstundenCommand;
import com.example.onionarchitecture.domain.sollstunden.model.BeraterSollStunden;
import com.example.onionarchitecture.interfaces.in.rest.controller.dto.SollstundenDto;
import com.example.onionarchitecture.interfaces.repositories.DbMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SollstudenCommandService {

    SollstundenService sollstundenService;

    public SollstundenDto sollstundeErstellen(SollstundenDto sollstundenDto) {

        SollstundenCommand cmd = new SollstundenCommand(DbMapper.mapSollstundenDtoToBeraterSollstunden(sollstundenDto));
        BeraterSollStunden beraterSollStunden1 = sollstundenService.erstellenSollstunden(cmd);

        return DbMapper.mapBeraterSollstundenToSollstundenDto(beraterSollStunden1);
    }

    public void deleteSollstunden(Long sollstundenId) {
        DeleteSollstundenCommand cmd = new DeleteSollstundenCommand(sollstundenId);
        sollstundenService.deleteSollstunden(cmd);
    }

    public void updateSollstunden(SollstundenDto sollstundenDto, Long id) {

        SollstundenCommand cmd = SollstundenCommand.builder()
                        .beraterSollStunden(DbMapper.mapSollstundenDtoToBeraterSollstunden(sollstundenDto))
                        .build();
         sollstundenService.updateSollstunden(cmd, id);
    }


}



