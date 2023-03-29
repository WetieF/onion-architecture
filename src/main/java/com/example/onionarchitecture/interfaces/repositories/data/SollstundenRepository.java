package com.example.onionarchitecture.interfaces.repositories.data;

import com.example.onionarchitecture.interfaces.repositories.data.entities.Sollstunden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.YearMonth;

public interface SollstundenRepository extends JpaRepository<Sollstunden, Long> {
    Sollstunden findByBeraternameAndMonat(String beratername, YearMonth monat);
}
