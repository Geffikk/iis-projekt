package org.forum.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skupina")
public class Skupina {

    /** NAZOV SKUPINY **/
    @Id
    @Column(name = "nazov")
    private String nazov;

    /** POPIS SKUPINY **/
    @Column(name = "popis")
    private String popis;

    /** ZAKLADATEL SKUPINY **/
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "uzivatel_meno1")
    private Uzivatel zakladatelSkupiny;


    /** VLAKNA SKUPINY **/
    @OneToMany(mappedBy = "skupinaVlakna" , cascade = CascadeType.ALL)
    private List<Vlakno> vlaknaSkupiny;

    /** CONSTRUCTORS **/
    public Skupina() {
    }

    public Skupina(String nazov, String popis) {
        this.nazov = nazov;
        this.popis = popis;
    }

    /** GETTERS AND SETTERS **/
    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public List<Vlakno> getVlaknaSkupiny() {
        return vlaknaSkupiny;
    }

    public void setVlaknaSkupiny(List<Vlakno> vlaknaSkupiny) {
        this.vlaknaSkupiny = vlaknaSkupiny;
    }


    public Uzivatel getZakladatelSkupiny() {
        return zakladatelSkupiny;
    }

    public void setZakladatelSkupiny(Uzivatel zakladatelSkupiny) {
        this.zakladatelSkupiny = zakladatelSkupiny;
    }


    // add methods for bi-directional relationship
    /** PRIDAT VLAKNO KU SKUPINE **/
    public void addVlaknoDoSkupiny(Vlakno tempVlakno) {
        if (vlaknaSkupiny == null) {
            vlaknaSkupiny = new ArrayList<>();
        }
        vlaknaSkupiny.add(tempVlakno);

        tempVlakno.setSkupinaVlakna(this);
    }

    /** PRIRADIT ZAKLADATELA SKUPINY **/
    public void addZakladatelaSkupiny(Uzivatel tempUzivatel) {
        zakladatelSkupiny = tempUzivatel;
    }


}
