package org.forum.entity;

import javax.persistence.*;

@Entity
@Table(name = "skupina")
public class Skupina {

    /** ID SKUPINY**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /** NAZOV SKUPINY **/
    @Column(name = "nazov", length = 50)
    private String nazov;

    /** POPIS SKUPINY **/
    @Column(name = "popis", length = 150)
    private String popis;

//    /** ZAKLADATEL SKUPINY **/
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name = "uzivatel_meno1")
//    private Uzivatel zakladatelSkupiny;
//
//    /** VLAKNA SKUPINY **/
//    @OneToMany(mappedBy = "skupinaVlakna" , cascade = CascadeType.ALL)
//    private List<Vlakno> vlaknaSkupiny;


    /** CONSTRUCTORS **/
    public Skupina() {
    }


    public Skupina(String nazov, String popis) {
        this.nazov = nazov;
        this.popis = popis;
    }

    /** GETTERS AND SETTERS **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
