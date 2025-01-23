package com.hande.germanwordsdeclension.model;


import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EndingCSVRecord {
    @CsvBindByName
    private String ending;

    private String examplePart;

    @CsvBindByName
    private String artikel;
}
