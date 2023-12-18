package com.example.sysDevLtd.entity.model.salesOfPoint;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    private String productName;
    private  int tradePrice;
    private  int mrp;
    private boolean status =true;
    @ManyToOne
    @JoinColumn(name = "companyID")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "suppliersID")
    private Suppliers suppliers;
}
