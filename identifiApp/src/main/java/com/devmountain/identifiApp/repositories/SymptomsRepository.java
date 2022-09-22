package com.devmountain.identifiApp.repositories;

import com.devmountain.identifiApp.entities.Activities;
import com.devmountain.identifiApp.entities.Symptoms;
import com.devmountain.identifiApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SymptomsRepository extends JpaRepository<Symptoms, Long> {
    List<Symptoms> findAllByUserEquals(User user);
}
