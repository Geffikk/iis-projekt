package org.forum.entities.user;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "uzivatelske_info")
public class UserAdditionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(mappedBy = "info")
    private User user;

    @Column(name = "mobil", length = 20)
    private String phone;

    @Column(name = "meno", length = 20)
    private String name;

    @Column(name = "priezvisko", length = 30)
    private String lastName;


    @Column(name = "mesto", length = 20)
    private String city;

    @Column(name = "bibliografia", length = 150)
    private String aboutMe;

    @Column(name = "footer", length = 50)
    private String footer;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return "UserAdditionalInfo{" +
                "id=" + id +
                ", user=" + user +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAdditionalInfo)) return false;
        UserAdditionalInfo that = (UserAdditionalInfo) o;
        return id == that.id &&
                Objects.equals(user, that.user) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(city, that.city) &&
                Objects.equals(aboutMe, that.aboutMe) &&
                Objects.equals(footer, that.footer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, phone, name, lastName, city, aboutMe, footer);
    }
}
