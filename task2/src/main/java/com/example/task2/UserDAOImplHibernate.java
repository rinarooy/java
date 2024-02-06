package com.example.task2;

import entity.UserRegAuth;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.sql.*;
import java.util.LinkedList;

public class UserDAOImplHibernate implements UserDUO{

    @Override
    public void writeList(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(new UserRegAuth("2test", "09876"));
        session.persist(new UserRegAuth("2test", "09876"));
        session.persist(new UserRegAuth("2test", "09876"));
        tx1.commit();
        session.close();
    }

    @Override
    public LinkedList<User> takeList() {
        return null;
    }
}
