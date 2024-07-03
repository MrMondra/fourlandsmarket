package com.fourlands.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "profiles")
@Getter
@Setter
public class ProfileEntity {
    @Id
    @Column(name = "id_profile")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfile;

    //good
    @OneToMany(mappedBy = "profileEntity")
    private List<UserEntity> usersEntities;

    private String description;
    private String name;
}
