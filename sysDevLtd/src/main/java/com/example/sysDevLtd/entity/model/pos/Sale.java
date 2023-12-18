package com.example.sysDevLtd.entity.model.pos;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "sale_date")
    private Date saleDate;

    @Column(name = "customer_name")
    private int customer;

    @Column(name = "sale_price")
    private int price;

    // Other sale attributes (e.g., customer, price, etc.)

    // Getters and setters
}
