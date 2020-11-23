package org.forum.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prispevok")
public class Prispevok {

    /** ID PRISPEVKU **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /** VLAKNO PRISPEVKU**/
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_vlakna")
    private Vlakno vlaknoPrispevku;

    /** ZAKLADATEL PRISPEVKU **/
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_uzivatela")
    private Uzivatel zakladatelPrispevku;

    /** OBSAH PRISPEVKU **/
    @Column(name = "obsah")
    private String obsah;

    /** RANKING PRISPEVKU **/
    @Column(name = "ranking")
    private Integer ranking;

    @Column(name = "datum_zalozenia", updatable = false, nullable = false)
    private Date datumZalozenia;

    @Column(name = "posledny_datum_upravy", nullable = false)
    private Date poslednyDatumUpravy;

    /** CONSTRUCTORS **/
    public Prispevok() {
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

    public Prispevok(String obsah, Integer ranking) {
        this.obsah = obsah;
        this.ranking = ranking;
    }

    /** GETTERS AND SETTERS **/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vlakno getVlaknoPrispevku() {
        return vlaknoPrispevku;
    }

    public void setVlaknoPrispevku(Vlakno vlaknoPrispevku) {
        this.vlaknoPrispevku = vlaknoPrispevku;
    }

    public Uzivatel getZakladatelPrispevku() {
        return zakladatelPrispevku;
    }

    public void setZakladatelPrispevku(Uzivatel zakladatelPrispevku) {
        this.zakladatelPrispevku = zakladatelPrispevku;
    }

    public String getObsah() {
        return obsah;
    }

    public void setObsah(String obsah) {
        this.obsah = obsah;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
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



}
