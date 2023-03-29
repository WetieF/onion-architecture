package com.example.onionarchitecture.application.exceptions.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorInfo {
    String code;
    String message;

    public ErrorInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
