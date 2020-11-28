package org.forum.entities.user;

import org.forum.entities.Section;
import org.forum.entities.user.activation.ActivationCode;

import javax.persistence.*;
import java.util.*;

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
    private int active = 1;

    @Column(name = "is_email_verifed")
    private boolean removed;

    @Column(name = "datum_registarcie")
    private Date createdAt;

    @Column(name = "posledny_datum_prihlasenia")
    private Date lastLoginTime;

    @Column(name = "rola")
    private String role = "USER";

    @Column(name = "id_profile_picture")
    private int idProfilePicture;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uzivatelske_info_id")
    private UserAdditionalInfo info;

    @OneToOne(mappedBy = "user")
    private ActivationCode activationCode;

    @Column(name = "je_verejny")
    private int isPublic = 1;

    @ManyToMany
    @JoinTable(
            name = "moderatori_skupiny",
            joinColumns = @JoinColumn(name = "id_uzivatela"),
            inverseJoinColumns = @JoinColumn(name = "id_skupiny")
    )
    private List<Section> moderatorOfSections;

    @ManyToMany
    @JoinTable(
            name = "clenovia_skupiny",
            joinColumns = @JoinColumn(name = "id_uzivatela"),
            inverseJoinColumns = @JoinColumn(name = "id_skupiny")
    )
    private List<Section> memberOfSections;

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

    public int isActive() {
        return active;
    }

    public void setActive(int active) {
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

    public String  getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIdProfilePicture() {
        return idProfilePicture;
    }

    public void setIdProfilePicture(int idProfilePicture) {
        this.idProfilePicture = idProfilePicture;
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

    public int getActive() {
        return active;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    public List<Section> getModeratorOfSections() {
        return moderatorOfSections;
    }

    public void setModeratorOfSections(List<Section> sections) {
        this.moderatorOfSections = sections;
    }

    public List<Section> getMemberOfSections() {
        return memberOfSections;
    }

    public void setMemberOfSections(List<Section> memberOfSections) {
        this.memberOfSections = memberOfSections;
    }

    public List<String> getRoleList() {
        if(this.role.length() > 0) {
            return Arrays.asList(this.role.split(","));
        }
        return new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                active == user.active &&
                removed == user.removed &&
                idProfilePicture == user.idProfilePicture &&
                isPublic == user.isPublic &&
                email.equals(user.email) &&
                username.equals(user.username) &&
                password.equals(user.password) &&
                createdAt.equals(user.createdAt) &&
                Objects.equals(lastLoginTime, user.lastLoginTime) &&
                role.equals(user.role) &&
                info.equals(user.info) &&
                activationCode.equals(user.activationCode) &&
                Objects.equals(moderatorOfSections, user.moderatorOfSections) &&
                Objects.equals(memberOfSections, user.memberOfSections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, password, active, removed, createdAt, lastLoginTime, role, idProfilePicture, info, activationCode, isPublic, moderatorOfSections, memberOfSections);
    }
}
