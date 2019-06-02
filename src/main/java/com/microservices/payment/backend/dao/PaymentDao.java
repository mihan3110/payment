package com.microservices.payment.backend.dao;

import com.microservices.payment.backend.model.Payment;
import com.microservices.payment.backend.util.HibernateSessionFactoryUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.List;

public class PaymentDao implements PaymentDb{
    //Поиск платежа по referenceNu,ber через параметр
    @Override
    public Payment findByReferenceNumber(String referenceNumber) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Payment where referenceNumber = :param");
        q.setParameter("param", referenceNumber);
        return (Payment) q.uniqueResult();
    }
//Проверка на существование

    //Создание платежа через транзакцию
    @Override
    public void createPayment(Payment payment) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(payment);
        transaction.commit();
    }

    //Вывод истории платежей за указанный период через Criteria
    @Override
    public List<Payment> getRestricted(Timestamp startDate, Timestamp endDate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Payment.class);
        criteria.add(Restrictions.ge("dateStamp", startDate));
        criteria.add(Restrictions.lt("dateStamp", endDate));
        return criteria.list();
    }

    //Удаление платежа по referenceNumber через транззакцию
    @Override
    public void deleteByReferenceNumebr(String referenceNumber) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(findByReferenceNumber(referenceNumber));
        tx1.commit();
        session.close();
    }

}