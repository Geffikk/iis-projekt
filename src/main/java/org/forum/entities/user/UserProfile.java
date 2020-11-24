package org.forum.entities.user;

import org.forum.entities.Post;
import org.forum.entities.Topic;

import java.util.Set;

public class UserProfile {

    private User user;

    private Set<Post> prispevky;

    private Set<Topic> vlakna;

    public UserProfile() {
    }

    public UserProfile(User user, Set<Post> prispevky, Set<Topic> vlakna) {
        super();
        this.user = user;
        this.prispevky = prispevky;
        this.vlakna = vlakna;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Post> getPrispevky() {
        return prispevky;
    }

    public void setPrispevky(Set<Post> prispevky) {
        this.prispevky = prispevky;
    }

    public Set<Topic> getVlakna() {
        return vlakna;
    }

    public void setVlakna(Set<Topic> vlakna) {
        this.vlakna = vlakna;
    }
}
