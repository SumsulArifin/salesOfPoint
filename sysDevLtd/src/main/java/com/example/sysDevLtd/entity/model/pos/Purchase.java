package com.example.sysDevLtd.entity.model.pos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



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

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
