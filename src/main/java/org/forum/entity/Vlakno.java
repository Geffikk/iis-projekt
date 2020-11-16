package org.forum.entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vlakno")
public class Vlakno {

    /** ID VLAKNA **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /** PREDMET VLAKNA **/
    @Column(name = "predmet")
    private String predmet;

    /** ZAKLADATEL VLAKNA **/
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "uzivatel_meno2")
    private Uzivatel zakladatelVlakna;

    /** VLAKNO PATRI DO SKUPINY **/
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "skupina_nazov")
    private Skupina skupinaVlakna;

    /** PRISPEVKY PATRIACE DO VLAKNA **/
    @OneToMany(mappedBy = "vlaknoPrispevku" , cascade = CascadeType.ALL)
    private List<Prispevok> prispevkyVlakna;

    /** CONSTRUCTORS **/
    public Vlakno() {
    }

    public Vlakno(String predmet) {
        this.predmet = predmet;
    }

    /** GETTERS AND SETTERS **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public Skupina getSkupinaVlakna() {
        return skupinaVlakna;
    }

    public void setSkupinaVlakna(Skupina skupinaVlakna) {
        this.skupinaVlakna = skupinaVlakna;
    }

    public Uzivatel getZakladatelVlakna() {
        return zakladatelVlakna;
    }

    public void setZakladatelVlakna(Uzivatel zakladatelVlakna) {
        this.zakladatelVlakna = zakladatelVlakna;
    }

    // add methods for bi-directional relationship
    /** PRIRADIT ZAKLADATELA VLAKNA **/
    public void addZakladatelaVlakna(Uzivatel tempUzivatel) {
        zakladatelVlakna = tempUzivatel;
    }

    /** PRIRADIT SKUPINU VLAKNA **/
    public void addSkupinuVlakna(Skupina tempSkupina) {
        skupinaVlakna = tempSkupina;
    }

    /** PRIDAT PRISPEVOK DO VLAKNA **/
    public void addPrispevokDoVlakna(Prispevok tempPrispevok) {
        if (prispevkyVlakna == null) {
            prispevkyVlakna = new ArrayList<>();
        }
        prispevkyVlakna.add(tempPrispevok);

        tempPrispevok.setVlaknoPrispevku(this);
    }
}
