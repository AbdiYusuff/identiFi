package com.devmountain.identifiApp.controllers;

import com.devmountain.identifiApp.dtos.ActivitiesDto;
import com.devmountain.identifiApp.dtos.SymptomsDto;
import com.devmountain.identifiApp.services.ActivitiesService;
import com.devmountain.identifiApp.services.SymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/symptoms")
public class SymptomsController {
    @Autowired
    private SymptomsService symptomsService;
    @GetMapping("/user/{userId}")
    public List<SymptomsDto> getSymptomsByUser(@PathVariable Long userId){
        return symptomsService.getAllSymptomsByUserId(userId);}
    @GetMapping("/{symptomsId}")
    public Optional<SymptomsDto> getSymptomsById(@PathVariable Long symptomsId){
        return symptomsService.getSymptomsById(symptomsId);}
    @PostMapping("/user/{userId}")
    public void addSymptoms(@RequestBody SymptomsDto symptomsDto, @PathVariable Long userId){
        symptomsService.addSymptoms(symptomsDto, userId);
    }
    @PostMapping("/{symptomsId}")
    public void deleteSymptomsById(@PathVariable Long symptomsId){symptomsService.deleteSymptomsById(symptomsId);}
    @PutMapping
    public void updateSymptoms(@RequestBody SymptomsDto symptomsDto){symptomsService.updateSymptomsById(symptomsDto);}

}
