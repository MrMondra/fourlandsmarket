package com.fourlandsmarket.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "order_details")
@Getter
@Setter
public class OrderDetail {
    @Id
    @Column(name = "id_order_detail")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrderDetail;

    @OneToMany(mappedBy = "orderDetail")
    private List<Product> products;

    @OneToMany(mappedBy = "orderDetail")
    private List<Order> orders;

    private Integer quantity;
    @Column(name = "unit_price")
    private Double unitPrice;
    private Double discount;

}
