package com.example.trainmonitoring.controller;

import com.example.trainmonitoring.model.Train;
import com.example.trainmonitoring.model.Station; // Импортируйте класс Station
import com.example.trainmonitoring.repository.TrainRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trains")
public class TrainController {

    private final TrainRepository trainRepository;

    public TrainController(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    // Получение всех электричек
    @GetMapping
    public CollectionModel<EntityModel<Train>> getAllTrains() {
        List<EntityModel<Train>> trains = trainRepository.findAll().stream()
                .map(train -> EntityModel.of(train,
                        Link.of("/trains/" + train.getId(), "self"),
                        Link.of("/trains/" + train.getId() + "/stations", "stations")))
                .collect(Collectors.toList());

        return CollectionModel.of(trains, Link.of("/trains", "self"));
    }

    // Получение электрички по id
    @GetMapping("/{id}")
    public EntityModel<Train> getTrainById(@PathVariable String id) {
        Train train = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found"));
        return EntityModel.of(train, Link.of("/trains/" + id, "self"));
    }

    // Получение станций по id поезда
    @GetMapping("/{id}/stations")
    public CollectionModel<EntityModel<Station>> getStationsByTrainId(@PathVariable String id) {
        Train train = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found"));

        List<Station> stations = train.getStations(); // Получаем список станций поезда

        // Преобразуем список станций в HATEOAS
        List<EntityModel<Station>> stationModels = stations.stream()
                .map(station -> EntityModel.of(station,
                        Link.of("/trains/" + id + "/stations/" + station.getId(), "self")))
                .collect(Collectors.toList());

        return CollectionModel.of(stationModels, Link.of("/trains/" + id + "/stations", "self"));
    }
}
