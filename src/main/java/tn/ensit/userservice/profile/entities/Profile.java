package tn.ensit.userservice.profile.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import tn.ensit.userservice.user.entities.User;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    @OneToOne
    @JsonBackReference
    private User user;

    protected Profile() {
    }

    public Profile(String bio) {
        this.bio = bio;
    }

    public Profile(User user, String bio) {
        this.bio = bio;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", userId='" + user.getId() + '\'' +
                '}';
    }
}
