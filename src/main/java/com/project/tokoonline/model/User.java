package com.project.tokoonline.model;

import javax.persistence.*;

@Entity
@Table( name = "user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    @Column(name = "username")
    private String username = "No Name";

    @Column(name = "email")
    private String email = "Example@gmail.com";

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private @Lob String address;

    @Column(name = "phone_number")
    private int Hp;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + Hp + '\'' +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        Hp = hp;
    }
}

