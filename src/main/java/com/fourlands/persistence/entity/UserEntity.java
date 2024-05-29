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

    //good
    @OneToMany(mappedBy = "userEntity")
    private List<ReviewEntity> reviewEntities;

    //good
    @OneToMany(mappedBy = "userEntity")
    private List<OrderEntity> orderEntities;

    //good
    @OneToMany(mappedBy = "userEntity")
    private List<SessionEntity> sessionsEntities;

    @ManyToOne
    @JoinColumn(name = "id_profile", insertable = false, updatable = false)
    private ProfileEntity profileEntity;


    private String name;
    private String email;
    private String password;
    @Column(name = "shipping_address")
    private String shippingAddress;
}
