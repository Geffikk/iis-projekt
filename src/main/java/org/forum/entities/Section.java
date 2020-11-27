package org.forum.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "skupina")
public class Section {

    /** ID SKUPINY**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /** NAZOV SKUPINY **/
    @Column(name = "nazov", length = 50)
    private String name;

    /** POPIS SKUPINY **/
    @Column(name = "popis", length = 150)
    private String description;

    @Column(name = "je_verejna")
    private int isPublic = 1;

    /** CONSTRUCTORS **/
    public Section() {
    }


    public Section(String nazov, String popis) {
        this.name = nazov;
        this.description = popis;
    }

    /** GETTERS AND SETTERS **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
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
