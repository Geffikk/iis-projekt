package org.forum.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "uzivatel")
public class Uzivatel {

    /** MENO UZIVATELA **/
    @Id
    @Column(name = "meno")
    private String meno;

    /** PRIEZVISKO UZIVATELA **/
    @Column(name = "priezvisko")
    private String priezvisko;

    /** SKUPINY ZALOZENE UZIVATELOM **/
    @OneToMany(mappedBy = "zakladatelSkupiny" , cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private List<Skupina> zalozeneSkupiny;

    /** VLAKNA ZALOZENE UZIVATELOM **/
    @OneToMany(mappedBy = "zakladatelVlakna" , cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                                                         CascadeType.DETACH, CascadeType.REFRESH})
    private List<Vlakno> zalozeneVlakna;

    /** CONSTRUCTORS **/
    public Uzivatel() {
    }

    public Uzivatel(String meno, String priezvisko) {
        this.meno = meno;
        this.priezvisko = priezvisko;
    }

    /** GETTERS AND SETTERS **/
    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public List<Vlakno> getZalozeneVlakna() {
        return zalozeneVlakna;
    }

    public void setZalozeneVlakna(List<Vlakno> zalozeneVlakna) {
        this.zalozeneVlakna = zalozeneVlakna;
    }

    public List<Skupina> getZalozeneSkupiny() {
        return zalozeneSkupiny;
    }

    public void setZalozeneSkupiny(List<Skupina> zalozeneSkupiny) {
        this.zalozeneSkupiny = zalozeneSkupiny;
    }

    // add methods for bi-directional relationship
    /** PRIDAT ZALOZENU SKUPINU KU UZIVATELOVI **/
    public void addSkupinu(Skupina tempSkupina) {
        if (zalozeneSkupiny == null) {
            zalozeneSkupiny = new ArrayList<>();
        }
        zalozeneSkupiny.add(tempSkupina);

        tempSkupina.setZakladatelSkupiny(this);
    }

    /** PRIDAT ZALOZENE VLAKNO KU UZIVATELOVI **/
    public void addVlakno(Vlakno tempVlakno) {
        if (zalozeneVlakna == null) {
            zalozeneVlakna = new ArrayList<>();
        }
        zalozeneVlakna.add(tempVlakno);

        tempVlakno.setZakladatelVlakna(this);
    }

}
