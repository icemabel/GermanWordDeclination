package com.hande.germanwordsdeclension.services;

import com.hande.germanwordsdeclension.mapper.EndingMapper;
import com.hande.germanwordsdeclension.model.EndingDTO;
import com.hande.germanwordsdeclension.repositories.EndingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EndingServiceImpl implements EndingService {

    private final EndingRepository endingRepository;
    private final EndingMapper endingMapper;

    @Override
    public List<EndingDTO> getAllEndings() {
        return endingRepository.findAll()
                .stream()
                .map(endingMapper::endingToEndingDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EndingDTO getArtikelByEnding(EndingDTO ending) {
        return null;
    }

    @Override
    public EndingDTO saveEnding(EndingDTO artikel, String ending) {
        return null;
    }
}
