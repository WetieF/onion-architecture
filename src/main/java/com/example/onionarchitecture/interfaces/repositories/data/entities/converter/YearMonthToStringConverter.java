package com.example.onionarchitecture.interfaces.repositories.data.entities.converter;

import com.example.onionarchitecture.domain.exceptions.FalschesMonatsFormatException;

import javax.persistence.AttributeConverter;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class YearMonthToStringConverter implements AttributeConverter<YearMonth, String> {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");


    @Override
    public String convertToDatabaseColumn(YearMonth attribute) {
        if (attribute != null) {
            return attribute.toString();
        }
        return null;
    }

    @Override
    public YearMonth convertToEntityAttribute(String dbData) {
        /*try {
            return Objects.nonNull(dbData) ? YearMonth.parse(dbData, formatter) : null;
        } catch (DateTimeParseException e) {
            throw new FalschesMonatsFormatException(e.getMessage());
        }*/

        return Objects.nonNull(dbData) ? YearMonth.parse(dbData, formatter) : null;
    }
}
