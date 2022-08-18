package com.fashion.toucan.entities;

import javax.persistence.*;

@Entity
@Table(name="login")
public class Login {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true, length = 40)
    String username;
    @Column(nullable = false, length = 8)
    String password;


    public Login()
    {

    }

    public Login(Long id, String username, String password) {

        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
}