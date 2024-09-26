package com.example.trainmonitoring.controller;

import com.example.trainmonitoring.model.Train;
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

    private final TrainRepository trainRepository = new TrainRepository();

    // Возвращаем список всех электричек
    @GetMapping
    public CollectionModel<EntityModel<Train>> getAllTrains() {
        List<EntityModel<Train>> trains = trainRepository.findAll().stream()
                .map(train -> EntityModel.of(train,
                        Link.of("/trains/" + train.getId(), "self"),
                        Link.of("/trains/" + train.getId() + "/stations", "stations")))
                .collect(Collectors.toList());

        return CollectionModel.of(trains, Link.of("/trains", "self"));
    }
}
