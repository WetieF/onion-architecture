package com.example.onionarchitecture.interfaces.in.rest.controller.dto;

import lombok.*;

import java.time.YearMonth;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SollstundenDto {

    private Long id;
    @NonNull private String beratername;

    @NonNull private YearMonth monat;

    @NonNull private Integer arbeitstage;

    @NonNull private Double taeglicheArbeitsstunden;

    private Double urlaubstage;

    @NonNull private Double sollstunden;

    private Double schulungstage;

    private Double krankheitstage;

    private Double sonstiges;
}
