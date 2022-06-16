package com.as.takehomeassessement.repository;

import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.exception.CustomRuntimeException;
import com.as.takehomeassessement.parser.ICSVConverter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.Getter;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class CSVAbstractRepository<D extends IDomain> implements IRepository<D>{

    protected ICSVConverter<D> csvConverter;

    @Getter
    protected List<D> cache;

    @Getter
    protected boolean isDirtyCache = true;

    public void setDirtyCache(boolean b) {
        isDirtyCache = b;
    }

    protected CSVAbstractRepository(ICSVConverter<D> csvConverter) {
        this.csvConverter = csvConverter;
    }

    protected abstract String getFilePath();

    @Override
    public Optional<D> findById(int id) {
        return findAll().parallelStream()
                .filter(o -> Objects.equals(o.getId(), id))
                .findFirst();
    }

    @Override
    public List<D> findAll() throws CustomRuntimeException {

        if (!isDirtyCache) return new ArrayList<>(cache);

        cache = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(Objects.requireNonNull(getClass().getClassLoader().getResource(getFilePath())).getFile()))) {
            String[] values;
            csvReader.readNext(); //skipping the title row
            while ((values = csvReader.readNext()) != null) {
                cache.add(csvConverter.convertToDomain(values));
            }
            isDirtyCache = false;
        } catch (IOException | CsvValidationException e) {
            throw new CustomRuntimeException(e);
        }

        return new ArrayList<>(cache);
    }

}
