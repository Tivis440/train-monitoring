package com.example.trainmonitoring.model;

public class Train {
    private String id;
    private String trainNumber;  // Номер электрички
    private String departureStation;  // Станция отправления
    private String arrivalStation;  // Станция прибытия
    private String departureTime;  // Время отправления
    private String arrivalTime;  // Время прибытия
    private String status;  // Статус электрички (например, "on time", "delayed")

    // Конструктор по умолчанию (нужен для работы с JPA или других библиотек)
    public Train() {
    }

    // Конструктор с параметрами
    public Train(String id, String trainNumber, String departureStation, String arrivalStation,
                 String departureTime, String arrivalTime, String status) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
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
}
