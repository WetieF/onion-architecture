package com.example.onionarchitecture.application.exceptions.model;

import lombok.Getter;

@Getter
public enum FachlicherFehlerTyp {

    INVALIDER_PARAMETER("FF_1", "Parameter Invalid"),
    INVALIDE_AGE("FF_2", "Age muss not be negativ or greather than 200."),

    EMPLOYEE_NOT_FOUND_AGE("FF_3", "Employee not Found."),
    TAEGLICHE_ARBEITSTUNDE("FF_", "Tägliche Arbeitstunden dürfen nicht mehr als 10 sein."),
    MONATLICHE_ARBEITSTAGE("FF_","Es dürfen nicht zu viele Arbeitsstage erfasst werden."),
    MONATLICHE_ABWESENHEITSTAGE("",
            "Es dürfen nicht mehr Abwesenheitsstage (Urlaub, Krankheit, Schulung, Sonstiges) als Arbeitstage erfasst sein "),
    ARBEITSTAGEN_ABWESENHEITSTAGE_DARF_NICHT_NEGATIV_SEIN("",
            "Die Angaben zu Arbeitstagen oder Abwesenheitsstagen darf nicht negativ sein"),
    SOLLSTUNDEN_VALIDATION("", "Die Angaben zu Sollstunden ist nicht valide"),
    JAHR_MONAT_PARSE("", "Die Angaben zu Monat und Jahr sollen als yyyy-MM sein."),
    SOLLSTUNDEN_FUER_MONAT_VORHANDEN("", "Sollstunden für diesen Beraternamen in diesem Monat schon vorhanden.");


    FachlicherFehlerTyp(String code, String message) {
        this.message = message;
        this.code = code;
    }

    String code;
    String message;
}
