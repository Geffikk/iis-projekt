package org.forum.entity;

import javax.persistence.*;

@Entity
@Table(name = "ziadost")
public class Ziadost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "typ")
    private String typ;

    public Ziadost() {
    }

    public Ziadost(String typ) {
        this.typ = typ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
