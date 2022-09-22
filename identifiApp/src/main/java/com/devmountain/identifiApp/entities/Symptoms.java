package com.devmountain.identifiApp.entities;

import com.devmountain.identifiApp.dtos.SymptomsDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Symptoms")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Symptoms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String symptomName;
    @Column
    private Integer dateOccurred;
    @Column
    private Integer duration;
    @Column
    private Boolean callHelp;

    @ManyToOne
    @JsonBackReference
    private User user;

    public Symptoms(SymptomsDto symptomsDto){
        if(symptomsDto.getSymptomName() != null){
            this.symptomName = symptomsDto.getSymptomName();
        }
        if(symptomsDto.getDateOccurred() != null){
            this.dateOccurred = symptomsDto.getDateOccurred();
        }
        if(symptomsDto.getDuration() != null){
            this.duration = symptomsDto.getDuration();
        }
        this.callHelp = symptomsDto.getCallHelp();
    }

}
