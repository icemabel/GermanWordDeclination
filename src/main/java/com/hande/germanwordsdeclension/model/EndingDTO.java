package com.hande.germanwordsdeclension.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EndingDTO {

    @NotBlank
    @NotNull
    private String ending;

    @NotNull
    @Size(min = 3, max = 3)
    private String articel;
}
