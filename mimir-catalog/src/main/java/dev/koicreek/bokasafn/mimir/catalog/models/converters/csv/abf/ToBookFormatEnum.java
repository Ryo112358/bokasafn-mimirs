package dev.koicreek.bokasafn.mimir.catalog.models.converters.csv.abf;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import dev.koicreek.bokasafn.mimir.catalog.constants.BookFormat;

public class ToBookFormatEnum extends AbstractBeanField<BookFormat, String> {
    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        return BookFormat.from(value);
    }
}
