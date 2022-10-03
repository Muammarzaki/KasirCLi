package com.kasircli.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.kasircli.models.Product;

public class CsvHandler {

    private String TYPE = "text/csv";
    private Path file;
    private CSVFormat format = CSVFormat.newFormat(';');

    public CsvHandler(String file) {
        this.file = Path.of(file);

    }

    public List<Product> convertToObject() {
        try {
            CSVParser parse = new CSVParser(Files.newBufferedReader(this.file),
                    this.format);
            List<Product> lis = new ArrayList<>();

            Iterable<CSVRecord> records = parse.getRecords();

            for (CSVRecord csvRecord : records) {
                lis.add(new Product(csvRecord.get(0), Integer.valueOf(csvRecord.get(1)),
                        Integer.valueOf(csvRecord.get(2))).setDescription(csvRecord.get(3)));
            }
            parse.close();
            return lis;
        } catch (IOException e) {
            return null;
        }
    }

    public void convertToCsvFile() {

    }

    public String getTYPE() {
        return TYPE;
    }

    public Path getFile() {
        return file;
    }

}
