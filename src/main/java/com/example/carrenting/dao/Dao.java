package com.example.carrenting.dao;

public class Dao {
    private final static BookingDao bookingDao = new BookingDao();
    private final static CarDao carDao = new CarDao();
    private final static UserDao userDao = new UserDao();

    public Dao() {
    }

    public BookingDao getBookingDao() {
        return bookingDao;
    }

    public CarDao getCarDao() {
        return carDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
