package com.devmountain.identifiApp.services;

import com.devmountain.identifiApp.dtos.SymptomsDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface SymptomsService {
    @Transactional
    void addSymptoms(SymptomsDto symptomsDto, Long userId);

    @Transactional
    void deleteSymptomsById(Long symptomsId);

    @Transactional
    void updateSymptomsById(Long symptomsId);

    List<SymptomsDto> getAllSymptomsByUserId(Long userId);

    Optional<SymptomsDto> getSymptomsById(Long symptomsId);
}
