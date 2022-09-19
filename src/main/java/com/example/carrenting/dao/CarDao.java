package com.example.carrenting.dao;

import com.example.carrenting.entity.Booking;
import com.example.carrenting.entity.Car;
import com.example.carrenting.entity.User;
import com.example.carrenting.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private Dao dao = new Dao();
    private BookingDao bookingDao= dao.getBookingDao();
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

    public Car getCarById(int id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Car where id = " + id, Car.class).getSingleResult();
        }
    }

    public Car getCarByLicensePlate(String licensePlate){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Car where license_plate = '" + licensePlate + "'", Car.class).getSingleResult();
        }
    }

    public void deleteCarById(int id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Car.class);
            cr.add(Restrictions.eq("id", id));
            session.delete(cr.uniqueResult());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public ArrayList<Car> getCarDisponibili(LocalDate startDate, LocalDate finishDate){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Criteria cr = session.createCriteria(Booking.class);
            Criterion start = Restrictions.le("startDate", finishDate);
            Criterion last = Restrictions.ge("finishDate", startDate);

            cr.add(Restrictions.not(Restrictions.and(start, last)));
            //Prenotazioni disponibili
            List<Booking> bookings = cr.list();
            //Tutte le prenotazioni
            List<Booking> allBookings = bookingDao.getAllBookings();
            //Tutti gli ID delle macchine prenotate
            ArrayList<Integer>bookingIdCars = new ArrayList<>();
            for (Booking ob : allBookings) {
                bookingIdCars.add(ob.getCar().getId());
            }
            //Tutte le Macchine
            List<Car>allCars = getAllCars();
            //Tutte le macchine disponibili
            ArrayList<Car> carsDisp = new ArrayList<>();

            //Aggiungo le macchine non prenotate
            for (Car ob : allCars) {
                if (!bookingIdCars.contains(ob.getId())) {
                    carsDisp.add(ob);
                }
            }
            //Aggiungo macchine prenotate disponibili
            if (!bookings.isEmpty()){
                for (Booking booking : bookings) {
                    carsDisp.add(booking.getCar());
                }
            }






            return carsDisp;

        }
    }

}
