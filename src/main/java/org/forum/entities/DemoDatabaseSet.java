package org.forum.entities;

import org.forum.entities.user.*;
import org.forum.entities.user.activation.ActivationCode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DemoDatabaseSet {

    public static void main(String[] args) {

        // create session factories
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Topic.class)
                .addAnnotatedClass(Section.class)
                .addAnnotatedClass(ActivationCode.class)
                .addAnnotatedClass(UserAdditionalInfo.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();


        // create sessions

        Session session = factory.getCurrentSession();


        try {

            // create objects
            System.out.println("Creating new objects...");
            User tempUzivatel1 = new User("marosgeffert@gmail.com", "Marosko", "123456");
            User tempUzivatel2 = new User("patriktomov@gmail.com", "Patres", "123456");
            User tempUzivatel3 = new User("andrejchuj@gmail.com", "Ander", "123456");
            User tempUzivatel4 = new User("adamondrejka@gmail.com", "Adam", "123456");
            User tempUzivatel5 = new User("tomaslisina@gmail.com", "Tomasqo", "123456");

            UserAdditionalInfo tempInfo1 = new UserAdditionalInfo("441223118", "Maros", "Geffer", "Bardejov", "Som chuj1", "Chuj1");
            UserAdditionalInfo tempInfo2 = new UserAdditionalInfo("441223118", "Patrik", "Tomov", "Bardejov", "Som chuj2", "Chuj2");
            UserAdditionalInfo tempInfo3 = new UserAdditionalInfo("441223118", "Andrej", "Pavlovic", "Leopoldov", "Som chuj", "Chuj1");
            UserAdditionalInfo tempInfo4 = new UserAdditionalInfo("441223118", "Adam", "Ondejka", "Bardejov", "Som chuj", "Chuj1");
            UserAdditionalInfo tempInfo5 = new UserAdditionalInfo("441223118", "Tomas", "Lysicky", "Bardejov", "Som chuj", "Chuj1");


            tempUzivatel1.setInfo(tempInfo1);
            tempUzivatel2.setInfo(tempInfo2);
            tempUzivatel3.setInfo(tempInfo3);
            tempUzivatel4.setInfo(tempInfo4);
            tempUzivatel5.setInfo(tempInfo5);

            Section tempSkupina1 = new Section("IMA", "Matematika");
            Section tempSkupina2 = new Section("ISA", "Siete 2");
            Section tempSkupina3 = new Section("Hry", "Pocitacove hry");
            Section tempSkupina4 = new Section("Vtipy", "Vtipy");
            Section tempSkupina5 = new Section("Bazar", "BazarPiko");

            tempSkupina1.setUser(tempUzivatel1);
            tempSkupina3.setUser(tempUzivatel3);
            tempSkupina4.setUser(tempUzivatel5);
            tempSkupina2.setUser(tempUzivatel2);
            tempSkupina5.setUser(tempUzivatel4);


            Topic tempVlakno1 = new Topic("Polsemka");
            Topic tempVlakno2 = new Topic("Skuska");
            Topic tempVlakno3 = new Topic("Metin 2");
            Topic tempVlakno4 = new Topic("Predam sufusky");
            Topic tempVlakno5 = new Topic("Vtipy o ciganoch");
            Topic tempVlakno6 = new Topic("CSKO");

            tempVlakno1.setSection(tempSkupina1);
            tempVlakno2.setSection(tempSkupina1);
            tempVlakno3.setSection(tempSkupina3);
            tempVlakno4.setSection(tempSkupina5);
            tempVlakno5.setSection(tempSkupina4);
            tempVlakno6.setSection(tempSkupina3);

            tempVlakno1.setUser(tempUzivatel1);
            tempVlakno2.setUser(tempUzivatel1);
            tempVlakno3.setUser(tempUzivatel3);
            tempVlakno4.setUser(tempUzivatel2);
            tempVlakno5.setUser(tempUzivatel5);
            tempVlakno6.setUser(tempUzivatel3);


            Post tempPrispevok1 = new Post("Co bude na polsemke?", 0);
            Post tempPrispevok2 = new Post("Podla mna logaritmy.", 0);
            Post tempPrispevok3 = new Post("Ja si myslim ze nic.", 0);
            Post tempPrispevok4 = new Post("Co nove vo svete Metinu2?", 0);
            Post tempPrispevok5 = new Post("Viete, ako hovoríme navoňanej cigánke?\n" + "Arómka", 0);
            Post tempPrispevok6 = new Post("Stará cigánska múdrosť: ", 0);
            Post tempPrispevok7 = new Post("Vtip 5", 0);
            Post tempPrispevok8 = new Post("Vtip 6", 0);
            Post tempPrispevok9 = new Post("Kolko kilovaty ma sufusky?", 0);
            Post tempPrispevok10 = new Post("100000kW", 0);
            Post tempPrispevok11 = new Post("Kupim za 10 evry", 0);
            Post tempPrispevok12 = new Post("Ja tam 150 eur!", 0);
            Post tempPrispevok13 = new Post("Kolko FSP mate po update?", 0);
            Post tempPrispevok14 = new Post("Niekto hru?", 0);
            Post tempPrispevok15 = new Post("Sme 4 hladame este 1", 0);
            Post tempPrispevok16 = new Post("DM me pls", 0);


            tempPrispevok1.setTopic(tempVlakno1);
            tempPrispevok2.setTopic(tempVlakno1);
            tempPrispevok3.setTopic(tempVlakno1);
            tempPrispevok4.setTopic(tempVlakno3);
            tempPrispevok5.setTopic(tempVlakno5);
            tempPrispevok6.setTopic(tempVlakno5);
            tempPrispevok7.setTopic(tempVlakno5);
            tempPrispevok8.setTopic(tempVlakno5);
            tempPrispevok9.setTopic(tempVlakno4);
            tempPrispevok10.setTopic(tempVlakno4);
            tempPrispevok11.setTopic(tempVlakno4);
            tempPrispevok12.setTopic(tempVlakno4);
            tempPrispevok13.setTopic(tempVlakno6);
            tempPrispevok14.setTopic(tempVlakno6);
            tempPrispevok15.setTopic(tempVlakno6);
            tempPrispevok16.setTopic(tempVlakno6);


            tempPrispevok1.setUser(tempUzivatel1);
            tempPrispevok2.setUser(tempUzivatel3);
            tempPrispevok3.setUser(tempUzivatel2);
            tempPrispevok4.setUser(tempUzivatel5);
            tempPrispevok5.setUser(tempUzivatel5);
            tempPrispevok6.setUser(tempUzivatel4);
            tempPrispevok7.setUser(tempUzivatel1);
            tempPrispevok8.setUser(tempUzivatel1);
            tempPrispevok9.setUser(tempUzivatel2);
            tempPrispevok10.setUser(tempUzivatel3);
            tempPrispevok11.setUser(tempUzivatel3);
            tempPrispevok12.setUser(tempUzivatel3);
            tempPrispevok13.setUser(tempUzivatel5);
            tempPrispevok14.setUser(tempUzivatel5);
            tempPrispevok15.setUser(tempUzivatel4);
            tempPrispevok16.setUser(tempUzivatel4);


            // start a transactions
            session.beginTransaction();


            // save objectss
            System.out.println("Saving objects...");
            session.save(tempUzivatel1);
            session.save(tempUzivatel2);
            session.save(tempUzivatel3);
            session.save(tempUzivatel4);
            session.save(tempUzivatel5);

            session.save(tempInfo1);
            session.save(tempInfo2);
            session.save(tempInfo3);
            session.save(tempInfo4);
            session.save(tempInfo5);


            session.save(tempSkupina1);
            session.save(tempSkupina2);
            session.save(tempSkupina3);
            session.save(tempSkupina4);
            session.save(tempSkupina5);

            session.save(tempVlakno1);
            session.save(tempVlakno2);
            session.save(tempVlakno3);
            session.save(tempVlakno4);
            session.save(tempVlakno5);
            session.save(tempVlakno6);

            session.save(tempPrispevok1);
            session.save(tempPrispevok2);
            session.save(tempPrispevok3);
            session.save(tempPrispevok4);
            session.save(tempPrispevok5);
            session.save(tempPrispevok6);
            session.save(tempPrispevok7);
            session.save(tempPrispevok8);
            session.save(tempPrispevok9);
            session.save(tempPrispevok10);
            session.save(tempPrispevok11);
            session.save(tempPrispevok12);
            session.save(tempPrispevok13);
            session.save(tempPrispevok14);
            session.save(tempPrispevok15);
            session.save(tempPrispevok16);


            // commit transaction
            session.getTransaction().commit();


            System.out.println("DONE!!!");
        }
        finally {
            factory.close();

        }
    }
}
