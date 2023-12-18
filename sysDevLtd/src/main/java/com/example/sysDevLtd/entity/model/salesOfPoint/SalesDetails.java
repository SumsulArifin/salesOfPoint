package com.example.sysDevLtd.entity.model.salesOfPoint;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SalesDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sDetailsId;
    private int quantity;
    private String uom;
    private double price;
    private double subTotal;
    @ManyToOne
    @JoinColumn(name = "productID")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "sMasterId")
    private SalesMaster salesMaster;
}