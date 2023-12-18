package com.example.sysDevLtd.entity.model.salesOfPoint;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SalReturnDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sReturnDetailsId;

    private int salQuantity;
    private int retQuantity;
    private String uom;
    private double price;
    private double salSubTotal;
    private double retSubTotal;

    @ManyToOne
    @JoinColumn(name = "sReturnMId")
    private SalesReturnMaster salesReturnMaster;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Products product;
}