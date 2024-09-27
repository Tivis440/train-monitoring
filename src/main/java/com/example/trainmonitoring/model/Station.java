package com.example.trainmonitoring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Station {

    @Id
    private String id;  // Уникальный идентификатор станции
    private String stationName;  // Название станции
    private String arrivalTime;  // Время прибытия на станцию
    private String departureTime;  // Время отправления со станции

    // Конструктор по умолчанию
    public Station() {
    }

    // Конструктор с параметрами
    public Station(String id, String stationName, String arrivalTime, String departureTime) {
        this.id = id;
        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
