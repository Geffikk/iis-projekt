package org.forum.entities;

import org.forum.entities.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "skupina")
public class Section {

    /** ID SKUPINY**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /** ZAKLADATEL SKUPINY **/
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_uzivatela")
    private User user;

    /** NAZOV SKUPINY **/
    @Column(name = "nazov", length = 50)
    private String name;

    /** POPIS SKUPINY **/
    @Column(name = "popis", length = 150)
    private String description;

    @Column(name = "datum_zalozenia", updatable = false, nullable = false)
    private Date creationDate;

    @Column(name = "je_verejna")
    private int isPublic = 1;

    @ManyToMany
    @JoinTable(
            name = "moderators",
            joinColumns = @JoinColumn(name = "id_skupiny"),
            inverseJoinColumns = @JoinColumn(name = "id_uzivatela")
    )
    private List<User> moderators;

    /** CONSTRUCTORS **/
    public Section() {
    }


    public Section(String nazov, String popis) {
        this.name = nazov;
        this.description = popis;
    }

    @PrePersist
    protected void onCreate() {
        this.creationDate = new Date();
    }

    /** GETTERS AND SETTERS **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    public List<User> getModerators() {
        return moderators;
    }

    public void setModerators(List<User> moderators) {
        this.moderators = moderators;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;
        Section section = (Section) o;
        return id == section.id &&
                Objects.equals(name, section.name) &&
                Objects.equals(description, section.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
