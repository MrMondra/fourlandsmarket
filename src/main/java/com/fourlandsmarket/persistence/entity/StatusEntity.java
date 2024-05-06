package com.fourlandsmarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "status")
@Getter
@Setter
public class StatusEntity {
    @Id
    @Column(name = "id_status")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStatus;

    @OneToMany(mappedBy = "statusEntity")
    private List<OrderEntity> orderEntities;

    private String description;
    private String name;
}
