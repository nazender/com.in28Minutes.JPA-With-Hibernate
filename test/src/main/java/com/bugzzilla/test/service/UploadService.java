package com.bugzzilla.test.service;

import com.bugzzilla.test.Entity.Dummy;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;


@Service
public class UploadService {

    public void parseCSV(MultipartFile file) {

        CsvMapper csvMapper = new CsvMapper();

        CsvSchema schema = CsvSchema.builder()
                .addColumn("studentEmail")
                .addColumn("firstName")
                .addColumn("firstName")
                .addColumn("studentId")
                .addColumn("studentCollege")
                .build();




        ObjectReader oReader = csvMapper.reader(Dummy.class).with(schema);

        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            MappingIterator<Dummy> mi = oReader.readValues(reader);
            while (mi.hasNext()) {
                System.err.println(mi.next());
            }
        } catch (Exception e) {

        }
    }
}
