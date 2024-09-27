package com.example.trainmonitoring.repository;

import com.example.trainmonitoring.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, String> {

}
