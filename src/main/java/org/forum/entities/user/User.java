package org.forum.entities.user;

import org.forum.entities.user.activation.ActivationCode;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "uzivatel")
public class User {

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
    private String username;

    /** HESLO UZIVATELA **/
    @Column(name = "heslo", length = 60, nullable = false)
    private String password;

    @Column(name = "je_aktivny")
    private boolean active;

    @Column(name = "is_email_verifed")
    private boolean removed;

    @Column(name = "datum_registarcie")
    private Date createdAt;

    @Column(name = "posledny_datum_prihlasenia")
    private Date lastLoginTime;

    @Column(name = "pohlavie")
    private Gender gender;

    @Column(name = "rola")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uzivatelske_info_id")
    private UserAdditionalInfo info;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activation_code_id")
    private ActivationCode activationCode;


    /** CONSTRUCTORS **/
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    public User() {
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserAdditionalInfo getInfo() {
        return info;
    }

    public void setInfo(UserAdditionalInfo info) {
        this.info = info;
    }

    public ActivationCode getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(ActivationCode activationCode) {
        this.activationCode = activationCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", removed=" + removed +
                ", createdAt=" + createdAt +
                ", lastLoginTime=" + lastLoginTime +
                ", gender=" + gender +
                ", role=" + role +
                ", info=" + info +
                ", activationCode=" + activationCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                active == user.active &&
                removed == user.removed &&
                Objects.equals(email, user.email) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(createdAt, user.createdAt) &&
                Objects.equals(lastLoginTime, user.lastLoginTime) &&
                gender == user.gender &&
                role == user.role &&
                Objects.equals(info, user.info) &&
                Objects.equals(activationCode, user.activationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, password, active, removed, createdAt, lastLoginTime, gender, role, info, activationCode);
    }
}
