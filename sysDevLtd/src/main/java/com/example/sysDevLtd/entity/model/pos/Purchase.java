package com.example.sysDevLtd.entity.model.pos;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "price")
    private int price;

    @Column(name = "payment_method")
    private String payment;

}
