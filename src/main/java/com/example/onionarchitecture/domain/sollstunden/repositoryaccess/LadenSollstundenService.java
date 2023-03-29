package com.example.onionarchitecture.domain.sollstunden.repositoryaccess;

import com.example.onionarchitecture.domain.sollstunden.model.BeraterSollStunden;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Sollstunden;

import java.time.YearMonth;
import java.util.List;

public interface LadenSollstundenService {
    BeraterSollStunden getBeraterSollstundenById(Long id);
    List<BeraterSollStunden> getListBeraterSollstunden();
    //BeraterSollStunden getSomeoneById(Long id);
    BeraterSollStunden findByBeraternameAndMonat(String beratername, YearMonth monat);
}
