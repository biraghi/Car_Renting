package com.example.carrenting.dao;

import com.example.carrenting.entity.Car;
import com.example.carrenting.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CarDao {
    public void saveCar(Car car) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(car);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List< Car > getAllCars() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Car", Car.class).list();
        }
    }
}