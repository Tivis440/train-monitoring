package com.example.trainmonitoring.repository;

import com.example.trainmonitoring.model.Train;
import java.util.ArrayList;
import java.util.List;

public class TrainRepository {

    private List<Train> trains = new ArrayList<>();

    public TrainRepository() {
        // Добавляем тестовые данные
        trains.add(new Train("1", "123A", "Station A", "Station B", "10:00", "12:00", "on time"));
        trains.add(new Train("2", "124B", "Station C", "Station D", "11:00", "13:00", "delayed"));
    }

    public List<Train> findAll() {
        return trains;
    }

    public Train findById(String id) {
        return trains.stream().filter(train -> train.getId().equals(id)).findFirst().orElse(null);
    }
}
