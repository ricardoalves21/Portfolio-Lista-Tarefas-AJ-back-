package com.ricardo.enums.converters;

import com.ricardo.enums.Etapa;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class EtapaConverter implements AttributeConverter<Etapa, String> {


    @Override
    public String convertToDatabaseColumn(Etapa etapa) {

        if(etapa == null) {
            return null;
        }
        return etapa.getValue();
    }

    @Override
    public Etapa convertToEntityAttribute(String value) {

        if(value == null) {
            return null;
        }
        return Stream.of(Etapa.values())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
