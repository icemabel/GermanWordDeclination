package com.hande.germanwordsdeclension;

import com.hande.germanwordsdeclension.entities.Ending;
import com.hande.germanwordsdeclension.model.EndingCSVRecord;
import com.hande.germanwordsdeclension.model.EndingDTO;
import com.hande.germanwordsdeclension.repositories.EndingRepository;
import com.hande.germanwordsdeclension.services.EndingCsvService;
import com.hande.germanwordsdeclension.services.EndingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class bootstrap implements CommandLineRunner {
    private final EndingCsvService endingCsvService;
    private final EndingRepository endingRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadCsvData();
    }

    private void loadCsvData() throws FileNotFoundException {
        File file = new File("classpath:csvdata/Artikel_Endungen.csv");

        List<EndingCSVRecord> records = endingCsvService.convertCSV(file);

        records.forEach(endingCSVRecord -> {
            String line = endingCSVRecord.getEnding();
            String[] parts = line.split("\\(e\\.g\\.,");
            String ending = parts[0];
            String examplePart = parts[1].replace(")", "").trim();
            endingCSVRecord.setEnding(ending);
            endingCSVRecord.setExamplePart(examplePart);

        endingRepository.save(Ending.builder()
                        .ending(StringUtils.abbreviate(endingCSVRecord.getEnding(), 50))
                        .artikel(endingCSVRecord.getArtikel())
                        .example(endingCSVRecord.getExamplePart())
                .build());

        });
    }
}
