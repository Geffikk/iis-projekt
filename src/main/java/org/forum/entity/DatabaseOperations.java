package org.forum.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseOperations {

    public DatabaseOperations() {
    }

    /** DATABASE OPERATIONS UZIVATEL **/
    public Uzivatel getUzivatel(String name) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Uzivatel.class)
                .addAnnotatedClass(Skupina.class)
                .addAnnotatedClass(Vlakno.class)
                .addAnnotatedClass(Prispevok.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Uzivatel tempUzivatel = session.get(Uzivatel.class, name);
        session.getTransaction().commit();
        return tempUzivatel;
    }

    public void addUzivatel(String name, String priezvisko) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Uzivatel.class)
                .addAnnotatedClass(Skupina.class)
                .addAnnotatedClass(Vlakno.class)
                .addAnnotatedClass(Prispevok.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Uzivatel tempUzivatel = new Uzivatel(name, priezvisko);
        session.save(tempUzivatel);
        session.getTransaction().commit();
    }


    /** DATABASE OPERATIONS SKUPINA **/
    public Skupina getSkupina(String name) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Uzivatel.class)
                .addAnnotatedClass(Skupina.class)
                .addAnnotatedClass(Vlakno.class)
                .addAnnotatedClass(Prispevok.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Skupina tempSkupina = session.get(Skupina.class, name);
        session.getTransaction().commit();
        return tempSkupina;
    }

    public void addSkupina(String name, String popis) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Uzivatel.class)
                .addAnnotatedClass(Skupina.class)
                .addAnnotatedClass(Vlakno.class)
                .addAnnotatedClass(Prispevok.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Skupina tempSkupina = new Skupina(name, popis);
        session.save(tempSkupina);
        session.getTransaction().commit();
    }


    /** DATABASE OPERATIONS VLAKNO **/
    public Vlakno getVlakno(int id) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Uzivatel.class)
                .addAnnotatedClass(Skupina.class)
                .addAnnotatedClass(Vlakno.class)
                .addAnnotatedClass(Prispevok.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Vlakno tempVlakno = session.get(Vlakno.class, id);
        session.getTransaction().commit();
        return tempVlakno;
    }

    public void addVlakno(String predmet) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Uzivatel.class)
                .addAnnotatedClass(Skupina.class)
                .addAnnotatedClass(Vlakno.class)
                .addAnnotatedClass(Prispevok.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Vlakno tempVlakno = new Vlakno(predmet);
        session.save(tempVlakno);
        session.getTransaction().commit();
    }


    /** DATABASE OPERATIONS PRISPEVOK **/
    public Prispevok getPrispevok(int id) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Uzivatel.class)
                .addAnnotatedClass(Skupina.class)
                .addAnnotatedClass(Vlakno.class)
                .addAnnotatedClass(Prispevok.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Prispevok tempPrispevok = session.get(Prispevok.class, id);
        session.getTransaction().commit();
        return tempPrispevok;
    }

    public void addPrispevok(String obsah, int ranking) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Uzivatel.class)
                .addAnnotatedClass(Skupina.class)
                .addAnnotatedClass(Vlakno.class)
                .addAnnotatedClass(Prispevok.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Prispevok tempPrispevok = new Prispevok(obsah, ranking);
        session.save(tempPrispevok);
        session.getTransaction().commit();
    }



}
