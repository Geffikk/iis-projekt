package org.forum.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "uzivatel")
public class Uzivatel {

    /** ID UZIVATELA **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /** EMAIL UZIVATELA **/
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /** MENO UZIVATELA **/
    @Column(name = "uzivatelske_meno", length = 50, nullable = false, unique = true)
    private String uzivatelskeMeno;

    /** HESLO UZIVATELA **/
    @Column(name = "heslo", length = 60, nullable = false)
    private String heslo;

    @Column(name = "je_aktivny")
    private boolean aktivny;

    @Column(name = "is_email_verifed")
    private boolean overenyEmail;

    @Column(name = "datum_registarcie")
    private Date zalozeny;

    @Column(name = "posledny_datum_prihlasenia")
    private Date poslednyDatumPrihlasenia;

    @Column(name = "pohlavie")
    private Pohlavie pohlavie;

    @Column(name = "rola")
    private Rola role = Rola.UNDEFINED;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uzivatelske_info_id")
    private UzivatelskeInfo info;

//    /** SKUPINY ZALOZENE UZIVATELOM **/
//    @OneToMany(mappedBy = "zakladatelSkupiny" , cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.DETACH, CascadeType.REFRESH})
//    private List<Skupina> zalozeneSkupiny;
//
//    /** VLAKNA ZALOZENE UZIVATELOM **/
//    @OneToMany(mappedBy = "zakladatelVlakna" , cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//                                                         CascadeType.DETACH, CascadeType.REFRESH})
//    private List<Vlakno> zalozeneVlakna;

    /** CONSTRUCTORS **/
    @PrePersist
    protected void onCreate() {
        this.zalozeny = new Date();
    }


    /** GETTERS AND SETTERS **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUzivatelskeMeno() {
        return uzivatelskeMeno;
    }

    public void setUzivatelskeMeno(String uzivatelskeMeno) {
        this.uzivatelskeMeno = uzivatelskeMeno;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public boolean isAktivny() {
        return aktivny;
    }

    public void setAktivny(boolean aktivny) {
        this.aktivny = aktivny;
    }

    public boolean isOverenyEmail() {
        return overenyEmail;
    }

    public void setOverenyEmail(boolean overenyEmail) {
        this.overenyEmail = overenyEmail;
    }

    public Date getZalozeny() {
        return zalozeny;
    }

    public void setZalozeny(Date zalozeny) {
        this.zalozeny = zalozeny;
    }

    public Date getPoslednyDatumPrihlasenia() {
        return poslednyDatumPrihlasenia;
    }

    public void setPoslednyDatumPrihlasenia(Date poslednyDatumPrihlasenia) {
        this.poslednyDatumPrihlasenia = poslednyDatumPrihlasenia;
    }

    public Pohlavie getPohlavie() {
        return pohlavie;
    }

    public void setPohlavie(Pohlavie pohlavie) {
        this.pohlavie = pohlavie;
    }

    public Rola getRole() {
        return role;
    }

    public void setRole(Rola role) {
        this.role = role;
    }

    public UzivatelskeInfo getInfo() {
        return info;
    }

    public void setInfo(UzivatelskeInfo info) {
        this.info = info;
    }
}
