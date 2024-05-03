package com.fourlandsmarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @OneToMany(mappedBy = "user")
    private List<ReviewEntity> reviews;

    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders;

    @OneToMany(mappedBy = "user")
    private List<SessionEntity> sessions;

    @ManyToOne
    @JoinColumn(name = "id_profile", insertable = false, updatable = false)
    private ProfileEntity profile;


    private String name;
    private String email;
    private String password;
    @Column(name = "shipping_address")
    private String shippingAddress;
}
