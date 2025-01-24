package com.hande.germanwordsdeclension.model;


import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EndingCSVRecord {
    @CsvBindByName
    private String ending;

    private String examplePart;

    @CsvBindByName
    private String artikel;
}
