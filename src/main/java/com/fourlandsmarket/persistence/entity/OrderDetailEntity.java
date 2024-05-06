package com.fourlandsmarket.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_details")
@Getter
@Setter
public class OrderDetailEntity {
    @Id
    @Column(name = "id_order_detail")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrderDetail;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "id_order", insertable = false, updatable = false)
    private OrderEntity orderEntity;


    private Integer quantity;
    @Column(name = "unit_price")
    private Double unitPrice;
    private Double discount;

}
