package com.example.carrenting.dao;

import com.example.carrenting.entity.Booking;
import com.example.carrenting.entity.Car;
import com.example.carrenting.entity.User;
import com.example.carrenting.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BookingDao {
    public void saveBooking(Booking booking) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(booking);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List< Booking > getAllBookings() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Booking", Booking.class).list();
        }
    }

    public Booking getBookingById(int id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Booking where id = " + id, Booking.class).getSingleResult();
        }
    }

    public void deleteBookingById(int id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Booking.class);
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
}
