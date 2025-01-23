package com.hande.germanwordsdeclension.mapper;

import com.hande.germanwordsdeclension.entities.Ending;
import com.hande.germanwordsdeclension.model.EndingDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EndingMapper {

    Ending endingDtotoEnding(EndingDTO endingDTO);

    EndingDTO endingToEndingDTO(Ending ending);
}
