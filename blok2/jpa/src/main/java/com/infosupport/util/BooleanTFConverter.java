package com.infosupport.util;

import jakarta.persistence.AttributeConverter;

public class BooleanTFConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        return value != null ? (value ? "T" : "F") : "";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case "T" -> true;
            case "F" -> false;
            default -> false;
        };
    }
}
