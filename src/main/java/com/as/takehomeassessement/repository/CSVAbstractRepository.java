package com.as.takehomeassessement.repository;

import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.exception.CustomRuntimeException;
import com.as.takehomeassessement.parser.ICSVConverter;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class CSVAbstractRepository<D extends IDomain> implements IRepository<D>{

    protected ICSVConverter<D> csvConverter;

    protected CSVAbstractRepository(ICSVConverter<D> csvConverter) {
        this.csvConverter = csvConverter;
    }

    protected abstract String getFilePath();

    @Override
    public Optional<D> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<D> findAll() throws CustomRuntimeException {
        List<D> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(Objects.requireNonNull(getClass().getClassLoader().getResource(getFilePath())).getFile()))) {
            String[] values;
            csvReader.readNext(); //skipping the title row
            while ((values = csvReader.readNext()) != null) {
                records.add(csvConverter.convertToDomain(values));
            }
        } catch (IOException e) {
            throw new CustomRuntimeException(e);
        }
        return records;
    }

}
