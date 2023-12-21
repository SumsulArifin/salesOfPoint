package com.example.sysDevLtd.entity.model.pos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status")
    private boolean status = false;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    //    @Column(name = "reorder_threshold")
    //    private int reorderThreshold;

}
