package com.example.trainmonitoring.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Train {

    @Id
    private String id;  // Уникальный идентификатор

    private String trainNumber;  // Номер электрички
    private String departureStation;  // Станция отправления
    private String arrivalStation;  // Станция прибытия
    private String departureTime;  // Время отправления
    private String arrivalTime;  // Время прибытия
    private String status;  // Статус электрички (например, "on time", "delayed")

    // Добавляем связь с таблицей Station
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id")  // Связываем станции с поездом через внешний ключ train_id
    private List<Station> stations;  // Список станций, через которые проходит поезд

    // Конструктор по умолчанию
    public Train() {
    }

    // Конструктор с параметрами
    public Train(String id, String trainNumber, String departureStation, String arrivalStation,
                 String departureTime, String arrivalTime, String status, List<Station> stations) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.stations = stations;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
