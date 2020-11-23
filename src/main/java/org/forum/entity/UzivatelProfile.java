package org.forum.entity;

import java.util.Set;

public class UzivatelProfile {

    private Uzivatel uzivatel;

    private Set<Prispevok> prispevky;

    private Set<Vlakno> vlakna;

    public UzivatelProfile() {
    }

    public UzivatelProfile(Uzivatel uzivatel, Set<Prispevok> prispevky, Set<Vlakno> vlakna) {
        super();
        this.uzivatel = uzivatel;
        this.prispevky = prispevky;
        this.vlakna = vlakna;
    }

    public Uzivatel getUzivatel() {
        return uzivatel;
    }

    public void setUzivatel(Uzivatel uzivatel) {
        this.uzivatel = uzivatel;
    }

    public Set<Prispevok> getPrispevky() {
        return prispevky;
    }

    public void setPrispevky(Set<Prispevok> prispevky) {
        this.prispevky = prispevky;
    }

    public Set<Vlakno> getVlakna() {
        return vlakna;
    }

    public void setVlakna(Set<Vlakno> vlakna) {
        this.vlakna = vlakna;
    }
}
