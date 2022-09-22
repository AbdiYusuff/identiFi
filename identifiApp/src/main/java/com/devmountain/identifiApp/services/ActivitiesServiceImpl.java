package com.devmountain.identifiApp.services;

import com.devmountain.identifiApp.dtos.ActivitiesDto;
import com.devmountain.identifiApp.dtos.SymptomsDto;
import com.devmountain.identifiApp.entities.Activities;
import com.devmountain.identifiApp.entities.Symptoms;
import com.devmountain.identifiApp.entities.User;
import com.devmountain.identifiApp.repositories.ActivitiesRepository;
import com.devmountain.identifiApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ActivitiesRepository activitiesRepository;


    @Override
    @Transactional
    public void addActivities(ActivitiesDto activitiesDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Activities activities = new Activities(activitiesDto);
        userOptional.ifPresent(activities::setUser);
        activitiesRepository.saveAndFlush(activities);
    }

    @Override
    @Transactional
    public void deleteActivitiesById(Long activitiesId){
        Optional<Activities> activitiesOptional = activitiesRepository.findById(activitiesId);
        activitiesOptional.ifPresent(activities -> activitiesRepository.delete(activities));
    }

    @Override
    @Transactional
    public void updateActivitiesById(ActivitiesDto activitiesDto){
        Optional<Activities> activitiesOptional = activitiesRepository.findById(activitiesDto.getId());
        activitiesOptional.ifPresent(activities -> {
            activities.setLocation(activitiesDto.getLocation());
            activities.setFoodRelated(activitiesDto.getFoodRelated());
            activities.setExerciseRelated(activitiesDto.getExerciseRelated());
            activities.setDuration(activitiesDto.getDuration());
        });
    }

    @Override
    public List<ActivitiesDto> getAllActivitiesByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<Activities> activitiesList = activitiesRepository.findAllByUserEquals(userOptional.get());
            return activitiesList.stream().map(activities -> new ActivitiesDto(activities)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<ActivitiesDto> getActivitiesById(Long activitiesId) {
        Optional<Activities> activitiesOptional = activitiesRepository.findById(activitiesId);
        if (activitiesOptional.isPresent()){
            return Optional.of(new ActivitiesDto(activitiesOptional.get()));
        }
        return Optional.empty();
    }
}
