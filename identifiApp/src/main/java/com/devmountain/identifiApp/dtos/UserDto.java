package com.devmountain.identifiApp.dtos;

import com.devmountain.identifiApp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String username;
    private String password;
    private Date dob;
    private Set<ActivitiesDto> activitiesDtoSet = new HashSet<>();
    private Set<SymptomsDto> symptomsDtoSet = new HashSet<>();

    public UserDto(User user) {
        if(user.getId() !=null){
            this.id = user.getId();
        }
        if(user.getUsername() !=null){
            this.username = user.getUsername();
        }
        if(user.getPassword() !=null){
            this.password = user.getPassword();
        }
        if(user.getDob() != null){
            this.dob = user.getDob();
        }
    }
}
