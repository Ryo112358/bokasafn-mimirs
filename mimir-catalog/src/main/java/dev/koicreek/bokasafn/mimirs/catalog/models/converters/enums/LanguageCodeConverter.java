package dev.koicreek.bokasafn.mimirs.catalog.models.converters.enums;

import dev.koicreek.bokasafn.mimirs.catalog.constants.Language;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LanguageCodeConverter implements AttributeConverter<Language, String> {
    @Override
    public String convertToDatabaseColumn(Language attribute) {
        return attribute.getIsoCode639_3();
    }

    @Override
    public Language convertToEntityAttribute(String dbData) {
        return Language.from(dbData);
    }
}
