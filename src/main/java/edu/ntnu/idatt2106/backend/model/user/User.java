package edu.ntnu.idatt2106.backend.model.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.*;
import lombok.*;

/**
 * The user-class
 * This is an entity for storing a user in the database
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String email;

    private Long phoneNumber;
    private String address;

    @OneToMany(mappedBy = "mainUser", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<SubUser> subUsers = new ArrayList<>();

    private byte[] password;
    private byte[] salt;

    public User(String email, Long phoneNumber, String address) {
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User(String email) {
        this.email = email;
    }

    public void addSubUser(SubUser subUser) {
        subUsers.add(subUser);
        subUser.setMainUser(this);
    }

    public void removeSubUser(SubUser subUser) {
        subUsers.remove(subUser);
    }

    /**
     * The overwritten equals method
     * @param o the object being compared
     * @return true or false depending on if it is equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    /**
     * The overwritten hashcode method
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString(){
        return "";
    }
}