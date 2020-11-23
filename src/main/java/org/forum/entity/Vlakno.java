package org.forum.entity;


import org.forum.entity.Uzivatel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vlakno")
public class Vlakno {

    /** ID VLAKNA **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /** ZAKLADATEL VLAKNA **/
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_uzivatela")
    private Uzivatel zakladatelVlakna;

    /** VLAKNO PATRI DO SKUPINY **/
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_skupiny")
    private Skupina skupinaVlakna;


    /** PREDMET VLAKNA **/
    @Column(name = "predmet", length = 50)
    private String predmet;

    @Column(name = "kontent", columnDefinition = "TEXT")
    private String kontent;

    @Column(name = "pohlady")
    private int pohlady;

    @Column(name = "datum_zalozenia", updatable = false, nullable = false)
    private Date datumZalozenia;

    @Column(name = "posledny_datum_upravy")
    private Date poslednyDatumUpravy;

    @Column(name = "je_zavrete")
    private boolean zavrete;

    /** CONSTRUCTORS **/
    public Vlakno() {
    }

    @PrePersist
    protected void onCreate() {
        this.datumZalozenia = new Date();
        this.poslednyDatumUpravy = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.poslednyDatumUpravy = new Date();
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

    public Uzivatel getZakladatelVlakna() {
        return zakladatelVlakna;
    }

    public void setZakladatelVlakna(Uzivatel zakladatelVlakna) {
        this.zakladatelVlakna = zakladatelVlakna;
    }

    public Skupina getSkupinaVlakna() {
        return skupinaVlakna;
    }

    public void setSkupinaVlakna(Skupina skupinaVlakna) {
        this.skupinaVlakna = skupinaVlakna;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public String getKontent() {
        return kontent;
    }

    public void setKontent(String kontent) {
        this.kontent = kontent;
    }

    public int getPohlady() {
        return pohlady;
    }

    public void setPohlady(int pohlady) {
        this.pohlady = pohlady;
    }

    public Date getDatumZalozenia() {
        return datumZalozenia;
    }

    public void setDatumZalozenia(Date datumZalozenia) {
        this.datumZalozenia = datumZalozenia;
    }

    public Date getPoslednyDatumUpravy() {
        return poslednyDatumUpravy;
    }

    public void setPoslednyDatumUpravy(Date poslednyDatumUpravy) {
        this.poslednyDatumUpravy = poslednyDatumUpravy;
    }

    public boolean isZavrete() {
        return zavrete;
    }

    public void setZavrete(boolean zavrete) {
        this.zavrete = zavrete;
    }
}
