package com.example.onionarchitecture.interfaces.repositories.data.entities;

import com.example.onionarchitecture.domain.sollstunden.model.BeraterSollStunden;
import com.example.onionarchitecture.interfaces.repositories.data.entities.converter.YearMonthToStringConverter;
import lombok.*;

import javax.persistence.*;
import java.time.YearMonth;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sollstunden {

    @Id
    @SequenceGenerator(
                    name = "SOLLSTUNDEN_ID_GENERATOR",
                    sequenceName = "SOLLSTUNDEN_SEQ",
                    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOLLSTUNDEN_ID_GENERATOR")
    @Column
    Long id;

    @Column(nullable = false)
    String beratername;

    @Convert(converter = YearMonthToStringConverter.class)
    @Column(nullable = false)
    YearMonth monat;

    @Column(nullable = false)
    Integer arbeitstage;

    @Column(nullable = false)
    Double taeglicheArbeitsstunden;

    @Column
    Double urlaubstage;

    @Column(nullable = false)
    Double sollstunden;

    @Column
    Double schulungstage;

    @Column
    Double krankheitstage;

    @Column
    Double sonstiges;

    /*public BeraterSollStunden mapSollstundenToBeraterSollstunden() {
        return BeraterSollStunden.builder()
                .id(getId())
                .beratername(getBeratername())
                .monat(getMonat())
                .arbeitstage(getArbeitstage())
                .taeglicheArbeitsstunden(getTaeglicheArbeitsstunden())
                .urlaubstage(getUrlaubstage())
                .sollstunden(getSollstunden())
                .schulungstage(getSchulungstage())
                .krankheitstage(getKrankheitstage())
                .sonstiges(getSonstiges())
                .build();
    }*/
}
