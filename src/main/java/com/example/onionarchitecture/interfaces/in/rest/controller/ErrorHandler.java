package com.example.onionarchitecture.interfaces.in.rest.controller;

import com.example.onionarchitecture.application.exceptions.model.ErrorInfo;
import com.example.onionarchitecture.application.exceptions.model.FachlicherFehlerTyp;
import com.example.onionarchitecture.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class ErrorHandler {

    @ExceptionHandler(KeinFirstUndLastNameException.class)
    public ResponseEntity<ErrorInfo> KeinFirstUndLastNameException(KeinFirstUndLastNameException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorInfo(FachlicherFehlerTyp.INVALIDER_PARAMETER .getCode(), FachlicherFehlerTyp.INVALIDER_PARAMETER.getMessage()));
    }

    @ExceptionHandler(AgeException.class)
    public ResponseEntity<ErrorInfo> AgeException(AgeException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorInfo(FachlicherFehlerTyp.INVALIDE_AGE .getCode(), FachlicherFehlerTyp.INVALIDE_AGE.getMessage()));
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorInfo> EmployeeNotFoundException(AgeException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorInfo(FachlicherFehlerTyp.EMPLOYEE_NOT_FOUND_AGE .getCode(), FachlicherFehlerTyp.EMPLOYEE_NOT_FOUND_AGE.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> handleBaseException(Exception exception) {
        /*if (exception.getMessage().contains("")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ErrorInfo(FachlicherFehlerTyp.JAHR_MONAT_PARSE.getCode(), FachlicherFehlerTyp.JAHR_MONAT_PARSE.getMessage()));
        }*/

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorInfo("", exception.toString()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorInfo> SollstundenFuerMonatBereitsVorhandenException(SollstundenFuerMonatBereitsVorhandenException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorInfo(FachlicherFehlerTyp.SOLLSTUNDEN_FUER_MONAT_VORHANDEN.getCode(), FachlicherFehlerTyp.SOLLSTUNDEN_FUER_MONAT_VORHANDEN.getMessage()));
    }

    /*@ExceptionHandler(FalschesMonatsFormatException.class)
    public ResponseEntity<ErrorInfo> jahrMonatParseException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorInfo(FachlicherFehlerTyp.JAHR_MONAT_PARSE.getCode(), FachlicherFehlerTyp.JAHR_MONAT_PARSE.getMessage()));
    }*/


}
