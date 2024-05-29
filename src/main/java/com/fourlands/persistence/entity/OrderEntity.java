package com.fourlands.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderEntity {
    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    @OneToMany(mappedBy = "orderEntity")
    private List<OrderDetailEntity> orderDetailEntities;

    //good
    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "id_status", insertable = false, updatable = false)
    private StatusEntity statusEntity;

    private LocalDateTime date;

    private Double total;
}
