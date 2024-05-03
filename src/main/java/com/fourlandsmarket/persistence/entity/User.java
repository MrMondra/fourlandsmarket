package com.fourlandsmarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Session> sessions;

    @ManyToOne
    @JoinColumn(name = "id_profile", insertable = false, updatable = false)
    private Profile profile;


    private String name;
    private String email;
    private String password;
    @Column(name = "shipping_address")
    private String shippingAddress;
}
