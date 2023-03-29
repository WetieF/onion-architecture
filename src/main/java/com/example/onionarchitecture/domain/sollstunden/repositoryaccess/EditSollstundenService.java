package com.example.onionarchitecture.domain.sollstunden.repositoryaccess;

import com.example.onionarchitecture.domain.sollstunden.model.BeraterSollStunden;
import com.example.onionarchitecture.interfaces.in.rest.controller.dto.SollstundenDto;

public interface EditSollstundenService {
    BeraterSollStunden erstellenSollstunden(BeraterSollStunden beraterSollStunden);
    void deleteSollstunden(Long sollId);
    //BeraterSollStunden updateSollstunden(BeraterSollStunden beraterSollStunden, Long id);
    void updateSollstunden(BeraterSollStunden beraterSollStunden, Long id);
}
