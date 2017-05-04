package com.htisolutions.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String forename;

    @NotNull
    private String surname;

    @NotNull
    private String nickname;

    @NotNull
    private String hashedPassword;

    public User() {}

    public User(String forename, String surname, String nickname, String hashedPassword) {
        this.forename = forename;
        this.surname = surname;
        this.nickname = nickname;
        this.hashedPassword = hashedPassword;
    }

    public String getForename() {
        return this.forename;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

}


