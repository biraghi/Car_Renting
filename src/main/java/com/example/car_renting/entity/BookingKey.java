package com.example.car_renting.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BookingKey implements Serializable {
    @Column(name = "user_id")
    private int userId;

    @Column(name = "car_id")
    private int carId;
}
