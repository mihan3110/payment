package com.microservices.payment.backend.dao;

import com.microservices.payment.backend.model.Payment;
import com.microservices.payment.backend.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.Iterator;
import java.util.List;

public class PaymentDao {

    public Payment findByReferenceNumber(String referenceNumber) {

       Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();

//
        System.out.println();
        Query q = session.createQuery("from Payment where referenceNumber = :param");
        q.setParameter("param",referenceNumber);

        return (Payment) q.uniqueResult();
    }

    public void createPayment(Payment payment) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(payment);
        tx1.commit();
        session.close();
    }

//    public void update(User user) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.update(user);
//        tx1.commit();
//        session.close();
//    }
//
//    public void delete(User user) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.delete(user);
//        tx1.commit();
//        session.close();
//    }
//
//    public Auto findAutoById(int id) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
//    }
//
//    public List<User> findAll() {
//        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
//        return users;
//    }
}