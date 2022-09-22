package com.devmountain.identifiApp.services;

import com.devmountain.identifiApp.dtos.ActivitiesDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ActivitiesService {
    @Transactional
    void addActivities(ActivitiesDto activitiesDto, Long userId);

    @Transactional
    void deleteActivitiesById(Long activitiesId);

    @Transactional
    void updateActivitiesById(ActivitiesDto activitiesDto);

    List<ActivitiesDto> getAllActivitiesByUserId(Long userId);

    Optional<ActivitiesDto> getActivitiesById(Long activitiesId);
}
