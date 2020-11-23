package org.forum.entity;

import javax.persistence.*;

@Entity
@Table(name = "uzivatelske_info")
public class UzivatelskeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(mappedBy = "info")
    private Uzivatel user;

    @Column(name = "mobil", length = 20)
    private String mobil;

    @Column(name = "meno", length = 20)
    private String meno;

    @Column(name = "priezvisko", length = 30)
    private String priezvisko;


    @Column(name = "mesto", length = 20)
    private String mesto;

    @Column(name = "bibliografia", length = 150)
    private String oMne;

    @Column(name = "footer", length = 50)
    private String footer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Uzivatel getUser() {
        return user;
    }

    public void setUser(Uzivatel user) {
        this.user = user;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

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

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getoMne() {
        return oMne;
    }

    public void setoMne(String oMne) {
        this.oMne = oMne;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }
}
