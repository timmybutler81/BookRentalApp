package com.butlert.bookrentalapp.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        if (aBoolean == null) {
            return null;
        }
        return aBoolean ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String data) {
        if (data == null) {
            return null;
        }
        return data.equals("Y");
    }
}
