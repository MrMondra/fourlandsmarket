package com.fourlandsmarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderEntity {
    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    @ManyToOne
    @JoinColumn(name = "id_order", insertable = false, updatable = false)
    private OrderDetailEntity orderDetail;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id_status", insertable = false, updatable = false)
    private StatusEntity status;

    private LocalDateTime date;

    private Double total;
}
