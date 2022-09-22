package com.devmountain.identifiApp.dtos;

import com.devmountain.identifiApp.entities.Activities;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitiesDto implements Serializable {
    private Long id;
    private String location;
    private Boolean foodRelated;
    private Boolean exerciseRelated;
    private Integer duration;
    private UserDto userDto;

    public ActivitiesDto(Activities activities){
        if(activities.getId() != null){
            this.id = activities.getId();
        }
        if(activities.getLocation() != null){
            this.location = activities.getLocation();
        }

        this.foodRelated = activities.getFoodRelated();

        this.exerciseRelated = getExerciseRelated();

        if(activities.getDuration() != null){
            this.duration = getDuration();
        }
    }
}
