package com.hande.germanwordsdeclension.services;

import com.hande.germanwordsdeclension.entities.Ending;
import com.hande.germanwordsdeclension.model.EndingCSVRecord;
import com.hande.germanwordsdeclension.repositories.EndingRepository;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EndingCsvServiceImpl implements EndingCsvService {

    @Autowired
    private EndingRepository endingRepository;

    @Override
    public List<EndingCSVRecord> convertCSV(File file) {
        try {
            List<EndingCSVRecord> records = new CsvToBeanBuilder<EndingCSVRecord>(new FileReader(file))
                    .withType(EndingCSVRecord.class)
                    .build().parse();
            return records;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readCsvAndSave(String filePath) {

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            List<Ending> records = new ArrayList<>();
            reader.readNext(); // Skip the header

            while ((line = reader.readNext()) != null) {
                Ending record = new Ending();
                record.setEnding(line[0]);
                record.setArtikel(line[1]);
                record.setExample(line[2]);
                records.add(record);
            }
            records.forEach(record -> System.out.println("Record: " + record));
            endingRepository.saveAll(records);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
