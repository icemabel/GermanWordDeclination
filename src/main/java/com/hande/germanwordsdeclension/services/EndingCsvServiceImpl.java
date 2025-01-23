package com.hande.germanwordsdeclension.services;

import com.hande.germanwordsdeclension.model.EndingCSVRecord;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class EndingCsvServiceImpl implements EndingCsvService {
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
}
