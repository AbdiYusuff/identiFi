package com.devmountain.identifiApp.entities;

import com.devmountain.identifiApp.dtos.ActivitiesDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activities {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column
        private String location;
        @Column
        private Boolean foodRelated;
        @Column
        private Boolean exerciseRelated;
        @Column
        private Integer duration;

        @ManyToOne
        @JsonBackReference
        private User user;

        public Activities(ActivitiesDto activitiesDto){
                if(activitiesDto.getLocation() != null){
                        this.location = activitiesDto.getLocation();
                }
                this.foodRelated = activitiesDto.getFoodRelated();

                this.exerciseRelated = activitiesDto.getExerciseRelated();

                if(activitiesDto.getDuration() != null){
                        this.duration = activitiesDto.getDuration();
                }
        }


}
