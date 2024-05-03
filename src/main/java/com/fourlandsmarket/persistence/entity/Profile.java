package com.fourlandsmarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "profiles")
@Getter
@Setter
public class Profile {
    @Id
    @Column(name = "id_profile")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfile;

    @OneToMany(mappedBy = "profile")
    private List<User> users;

    private String description;
    private String name;
}
