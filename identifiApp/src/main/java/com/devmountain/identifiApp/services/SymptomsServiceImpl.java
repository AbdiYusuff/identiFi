package com.devmountain.identifiApp.services;

import com.devmountain.identifiApp.dtos.SymptomsDto;
import com.devmountain.identifiApp.entities.Symptoms;
import com.devmountain.identifiApp.entities.User;
import com.devmountain.identifiApp.repositories.SymptomsRepository;
import com.devmountain.identifiApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SymptomsServiceImpl implements SymptomsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SymptomsRepository symptomsRepository;
    @Autowired
    private SymptomsDto symptomsDto;
    @Override
    @Transactional
    public void addSymptoms(SymptomsDto symptomsDto, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        Symptoms symptoms = new Symptoms(symptomsDto);
        userOptional.ifPresent((symptoms::setUser));
        symptomsRepository.saveAndFlush(symptoms);
    }
    @Override
    @Transactional
    public void deleteSymptomsById(Long symptomsId){
        Optional<Symptoms> symptomsOptional = symptomsRepository.findById(symptomsId);
        symptomsOptional.ifPresent(symptoms -> symptomsRepository.delete(symptoms));
    }
    @Override
    @Transactional
    public void updateSymptomsById(Long symptomsId){
        Optional<Symptoms> symptomsOptional = symptomsRepository.findById(symptomsDto.getId());
        symptomsOptional.ifPresent(symptoms -> {
            symptoms.setSymptomName(symptomsDto.getSymptomName());
            symptoms.setDateOccurred(symptomsDto.getDateOccurred());
            symptoms.setDuration(symptomsDto.getDuration());
            symptoms.setCallHelp(symptomsDto.getCallHelp());
        });
    }

    @Override
    public List<SymptomsDto> getAllSymptomsByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<Symptoms> symptomsListList = symptomsRepository.findAllByUserEquals(userOptional.get());
            return symptomsListList.stream().map(symptoms -> new SymptomsDto(symptoms)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<SymptomsDto> getSymptomsById(Long symptomsId) {
        Optional<Symptoms> symptomsOptional = symptomsRepository.findById(symptomsId);
        if (symptomsOptional.isPresent()){
            return Optional.of(new SymptomsDto(symptomsOptional.get()));
        }
        return Optional.empty();
    }

}
