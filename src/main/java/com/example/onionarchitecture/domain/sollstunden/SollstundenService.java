package com.example.onionarchitecture.domain.sollstunden;

import com.example.onionarchitecture.domain.exceptions.KeineSollstundenIdErlaubtException;
import com.example.onionarchitecture.domain.exceptions.SollstundenFuerMonatBereitsVorhandenException;
import com.example.onionarchitecture.domain.sollstunden.command.DeleteSollstundenCommand;
import com.example.onionarchitecture.domain.sollstunden.command.SollstundenCommand;
import com.example.onionarchitecture.domain.sollstunden.model.BeraterSollStunden;
import com.example.onionarchitecture.domain.sollstunden.repositoryaccess.EditSollstundenService;

import com.example.onionarchitecture.domain.sollstunden.repositoryaccess.LadenSollstundenService;
import com.example.onionarchitecture.interfaces.repositories.DbMapper;
import com.example.onionarchitecture.interfaces.repositories.data.SollstundenRepository;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Sollstunden;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class SollstundenService {

    EditSollstundenService editSollstundenService;
    LadenSollstundenService ladenSollstundenService;
    SollstundenRepository sollstundenRepository;

    public BeraterSollStunden erstellenSollstunden(SollstundenCommand cmd) {

        BeraterSollStunden beraterSollStunden = cmd.getBeraterSollStunden();

        if (Objects.nonNull(beraterSollStunden.getId()) && beraterSollStunden.getId() > 0)  {
            throw new KeineSollstundenIdErlaubtException();
        }

        BeraterSollStunden sollstundenDb =
                ladenSollstundenService.findByBeraternameAndMonat(beraterSollStunden.getBeratername(),
                                                                  beraterSollStunden.getMonat());

        if (Objects.nonNull(sollstundenDb)) {
            throw new SollstundenFuerMonatBereitsVorhandenException();
        }

        return editSollstundenService.erstellenSollstunden(beraterSollStunden);
    }

    public void deleteSollstunden(DeleteSollstundenCommand cmd) {
        editSollstundenService.deleteSollstunden(cmd.getId());
    }

    public void updateSollstunden(SollstundenCommand cmd, Long id) {
        BeraterSollStunden beraterSollstunden = cmd.getBeraterSollStunden();
        editSollstundenService.updateSollstunden(beraterSollstunden, id);
    }

}
