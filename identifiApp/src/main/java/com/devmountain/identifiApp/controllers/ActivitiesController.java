package com.devmountain.identifiApp.controllers;

import com.devmountain.identifiApp.dtos.ActivitiesDto;
import com.devmountain.identifiApp.services.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/activities")
public class ActivitiesController {
    @Autowired
    private ActivitiesService activitiesService;
    @GetMapping("/user/{userId}")
    public List<ActivitiesDto> getActivitiesByUser(@PathVariable Long userId){
        return activitiesService.getAllActivitiesByUserId(userId);}
    @GetMapping("/{activitiesId}")
    public Optional<ActivitiesDto> getActivitiesById(@PathVariable Long activitiesId){
        return activitiesService.getActivitiesById(activitiesId);}
    @PostMapping("/user/{userId}")
    public void addActivities(@RequestBody ActivitiesDto activitiesDto, @PathVariable Long userId){
        activitiesService.addActivities(activitiesDto, userId);
    }
    @PostMapping("/{activitiesId}")
    public void deleteActivitiesById(@PathVariable Long activitiesId){activitiesService.deleteActivitiesById(activitiesId);}
    @PutMapping
    public void updateActivities(@RequestBody ActivitiesDto activitiesDto){activitiesService.updateActivitiesById(activitiesDto);}

}
