package org.forum.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DemoDatabaseSet {

    public static void main(String[] args) {

        // create session factories
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Prispevok.class)
                .addAnnotatedClass(Vlakno.class)
                .addAnnotatedClass(Skupina.class)
                .addAnnotatedClass(Uzivatel.class)
                .buildSessionFactory();


        // create sessions

        Session session = factory.getCurrentSession();


        try {

            // create objects
            System.out.println("Creating new objects...");
            Uzivatel tempUzivatel1 = new Uzivatel("Maros", "Geffert");
            Uzivatel tempUzivatel2 = new Uzivatel("Patrik", "Tomov");
            Uzivatel tempUzivatel3 = new Uzivatel("Tomas", "Lisicky");
            Uzivatel tempUzivatel4 = new Uzivatel("Adam", "Ondrejka");
            Uzivatel tempUzivatel5 = new Uzivatel("Andrej", "Pavlovic");


            Skupina tempSkupina1 = new Skupina("IMA", "Matematika");
            Skupina tempSkupina2 = new Skupina("ISA", "Siete 2");
            Skupina tempSkupina3 = new Skupina("Hry", "Pocitacove hry");
            Skupina tempSkupina4 = new Skupina("Vtipy", "Vtipy");
            Skupina tempSkupina5 = new Skupina("Bazar", "BazarPiko");

            tempSkupina1.setZakladatelSkupiny(tempUzivatel1);
            tempSkupina2.setZakladatelSkupiny(tempUzivatel1);
            tempSkupina3.setZakladatelSkupiny(tempUzivatel3);
            tempSkupina4.setZakladatelSkupiny(tempUzivatel5);
            tempSkupina5.setZakladatelSkupiny(tempUzivatel2);

            Vlakno tempVlakno1 = new Vlakno("Polsemka");
            Vlakno tempVlakno2 = new Vlakno("Skuska");
            Vlakno tempVlakno3 = new Vlakno("Metin 2");
            Vlakno tempVlakno4 = new Vlakno("Predam sufusky");
            Vlakno tempVlakno5 = new Vlakno("Vtipy o ciganoch");
            Vlakno tempVlakno6 = new Vlakno("CSKO");

            tempVlakno1.setSkupinaVlakna(tempSkupina1);
            tempVlakno2.setSkupinaVlakna(tempSkupina1);
            tempVlakno3.setSkupinaVlakna(tempSkupina3);
            tempVlakno4.setSkupinaVlakna(tempSkupina5);
            tempVlakno5.setSkupinaVlakna(tempSkupina4);
            tempVlakno6.setSkupinaVlakna(tempSkupina3);

            tempVlakno1.setZakladatelVlakna(tempUzivatel1);
            tempVlakno2.setZakladatelVlakna(tempUzivatel1);
            tempVlakno3.setZakladatelVlakna(tempUzivatel3);
            tempVlakno4.setZakladatelVlakna(tempUzivatel2);
            tempVlakno5.setZakladatelVlakna(tempUzivatel5);
            tempVlakno6.setZakladatelVlakna(tempUzivatel3);


            Prispevok tempPrispevok1 = new Prispevok("Co bude na polsemke?", 0);
            Prispevok tempPrispevok2 = new Prispevok("Podla mna logaritmy.", 0);
            Prispevok tempPrispevok3 = new Prispevok("Ja si myslim ze nic.", 0);
            Prispevok tempPrispevok4 = new Prispevok("Co nove vo svete Metinu2?", 0);
            Prispevok tempPrispevok5 = new Prispevok("Viete, ako hovoríme navoňanej cigánke?\n" + "Arómka", 0);
            Prispevok tempPrispevok6 = new Prispevok("Stará cigánska múdrosť: ", 0);
            Prispevok tempPrispevok7 = new Prispevok("Vtip 5", 0);
            Prispevok tempPrispevok8 = new Prispevok("Vtip 6", 0);
            Prispevok tempPrispevok9 = new Prispevok("Kolko kilovaty ma sufusky?", 0);
            Prispevok tempPrispevok10 = new Prispevok("100000kW", 0);
            Prispevok tempPrispevok11 = new Prispevok("Kupim za 10 evry", 0);
            Prispevok tempPrispevok12 = new Prispevok("Ja tam 150 eur!", 0);
            Prispevok tempPrispevok13 = new Prispevok("Kolko FSP mate po update?", 0);
            Prispevok tempPrispevok14 = new Prispevok("Niekto hru?", 0);
            Prispevok tempPrispevok15 = new Prispevok("Sme 4 hladame este 1", 0);
            Prispevok tempPrispevok16 = new Prispevok("DM me pls", 0);


            tempPrispevok1.setVlaknoPrispevku(tempVlakno1);
            tempPrispevok2.setVlaknoPrispevku(tempVlakno1);
            tempPrispevok3.setVlaknoPrispevku(tempVlakno1);
            tempPrispevok4.setVlaknoPrispevku(tempVlakno3);
            tempPrispevok5.setVlaknoPrispevku(tempVlakno5);
            tempPrispevok6.setVlaknoPrispevku(tempVlakno5);
            tempPrispevok7.setVlaknoPrispevku(tempVlakno5);
            tempPrispevok8.setVlaknoPrispevku(tempVlakno5);
            tempPrispevok9.setVlaknoPrispevku(tempVlakno4);
            tempPrispevok10.setVlaknoPrispevku(tempVlakno4);
            tempPrispevok11.setVlaknoPrispevku(tempVlakno4);
            tempPrispevok12.setVlaknoPrispevku(tempVlakno4);
            tempPrispevok13.setVlaknoPrispevku(tempVlakno6);
            tempPrispevok14.setVlaknoPrispevku(tempVlakno6);
            tempPrispevok15.setVlaknoPrispevku(tempVlakno6);
            tempPrispevok16.setVlaknoPrispevku(tempVlakno6);


            // start a transactions
            session.beginTransaction();


            // save objectss
            System.out.println("Saving objects...");
            session.save(tempUzivatel1);
            session.save(tempUzivatel2);
            session.save(tempUzivatel3);
            session.save(tempUzivatel4);
            session.save(tempUzivatel5);

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
