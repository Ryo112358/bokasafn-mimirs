package dev.koicreek.bokasafn.mimir.catalog.models.converters.csv.abf;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import dev.koicreek.bokasafn.mimir.catalog.constants.Language;

public class ToLanguageEnum extends AbstractBeanField<Language, String> {
    @Override
    protected Language convert(String value) throws CsvDataTypeMismatchException {
        return Language.from(value);
    }
}
