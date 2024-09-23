package org.example.entity;

import javax.persistence.*;
@Entity
@Table(name = "addresses")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street",nullable = false)
    private String street;

    @Column(name = "city",nullable = false)
    private String city;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStreet() {
        return street;

    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }


}
