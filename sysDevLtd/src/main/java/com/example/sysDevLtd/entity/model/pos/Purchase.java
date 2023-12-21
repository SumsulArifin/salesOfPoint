package com.example.sysDevLtd.entity.model.pos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "purchases")
public class Purchase extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchasesId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "price")
    private int price;

    @Column(name = "payment_method")
    private String payment;

    @Column(name = "discount")
    private int discount;

    @Column(name = "total_amount")
    private int totalAmount;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stockId")
    private Stock stock;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "supplierId")
//    private Supplier supplier;

}
