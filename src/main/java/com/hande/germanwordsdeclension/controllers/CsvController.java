package com.hande.germanwordsdeclension.controllers;

import com.hande.germanwordsdeclension.services.EndingCsvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvController {
    @Autowired
    private EndingCsvServiceImpl endingCsvServiceImpl;


    @PostMapping("/upload-csv")
    public String uploadCsv(@RequestParam String filePath) {
        filePath = "src/main/resources/csvdata/Artikel_Endungen.csv";
        endingCsvServiceImpl.readCsvAndSave(filePath);
        return "success";
    }
}
