package com.example.trainmonitoring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.trainmonitoring.model.Train;
import com.example.trainmonitoring.model.Station;
import com.example.trainmonitoring.repository.TrainRepository;

import java.util.List;

@SpringBootApplication
public class TrainMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainMonitoringApplication.class, args);
    }

    // Метод для инициализации базы данных
    @Bean
    public CommandLineRunner initDatabase(TrainRepository trainRepository) {
        return args -> {
            // Создание станций
            Station station1 = new Station("1", "Station A", "2024-09-27 10:00:00", "2024-09-27 10:10:00");
            Station station2 = new Station("2", "Station B", "2024-09-27 12:00:00", "2024-09-27 12:05:00");
            List<Station> stationsForTrain1 = List.of(station1, station2);

            // Создание поезда с этими станциями
            Train train1 = new Train("1", "123A", "Station A", "Station B", "2024-09-27 10:00:00", "2024-09-27 12:00:00", "on time", stationsForTrain1);
            trainRepository.save(train1); // Сохраняем поезд в базу данных

            // Создание других станций и поезда
            Station station3 = new Station("3", "Station C", "2024-09-27 11:00:00", "2024-09-27 11:10:00");
            Station station4 = new Station("4", "Station D", "2024-09-27 13:00:00", "2024-09-27 13:05:00");
            List<Station> stationsForTrain2 = List.of(station3, station4);

            Train train2 = new Train("2", "124B", "Station C", "Station D", "2024-09-27 11:00:00", "2024-09-27 13:00:00", "delayed", stationsForTrain2);
            trainRepository.save(train2); // Сохраняем второй поезд в базу данных
        };
    }
}
