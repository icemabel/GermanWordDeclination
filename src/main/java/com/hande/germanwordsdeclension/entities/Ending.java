package com.hande.germanwordsdeclension.entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ending {

    @NotBlank
    @NotNull
    @Size(min = 1, max = 255)
    private String ending;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    private String artikel;

    private String example;
}
