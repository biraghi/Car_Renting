package com.example.car_renting.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="manufacturer")
    private String manufacturer;

    @Column(name="model")
    private String model;

    @Column(name="year_registration")
    private String yearRegistration;

    @Column(name="license_plate")
    private String licensePlate;

    @Column(name="type_name")
    private String typeName;

    /*
    @OneToMany(mappedBy = "car")
    private ArrayList<Booking> bookings;


     */
    public Car(){}

    public Car(String manufacturer, String model, String yearRegistration, String licensePlate, String typeName) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearRegistration = yearRegistration;
        this.licensePlate = licensePlate;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearRegistration() {
        return yearRegistration;
    }

    public void setYearRegistration(String yearRegistration) {
        this.yearRegistration = yearRegistration;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", yearRegistration='" + yearRegistration + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
