package com.devmountain.identifiApp.dtos;

import com.devmountain.identifiApp.entities.Activities;
import com.devmountain.identifiApp.entities.Symptoms;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomsDto implements Serializable {
    private Long id;
    private String symptomName;
    private Integer dateOccurred;
    private Integer duration;
    private Boolean callHelp;

    public SymptomsDto(Symptoms symptoms){
        if(symptoms.getId() != null){
            this.id = symptoms.getId();
        }
        if(symptoms.getSymptomName() != null){
            this.symptomName = symptoms.getSymptomName();
        }
        if(symptoms.getDateOccurred() != null){
            this.dateOccurred = symptoms.getDateOccurred();
        }
        if(symptoms.getDuration() != null){
            this.duration = symptoms.getDuration();
        }
        this.callHelp = symptoms.getCallHelp();

    }

}
