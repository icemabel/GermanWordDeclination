package com.hande.germanwordsdeclension.services;

import com.hande.germanwordsdeclension.model.EndingCSVRecord;

import java.io.File;
import java.util.List;

public interface EndingCsvService {
    List<EndingCSVRecord> convertCSV(File file);

    void readCsvAndSave(String filePath);
}
