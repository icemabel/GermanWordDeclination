package com.hande.germanwordsdeclension.services;

import com.hande.germanwordsdeclension.entities.Ending;
import com.hande.germanwordsdeclension.model.EndingDTO;

import java.util.List;

public interface EndingService {

    List<EndingDTO> getAllEndings();

    EndingDTO getArtikelByEnding(EndingDTO ending);

    EndingDTO saveEnding(EndingDTO artikel, String ending);
}
