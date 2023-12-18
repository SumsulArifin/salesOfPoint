package com.example.sysDevLtd.entity.model.salesOfPoint;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RcvReturnDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rRDetailsId;
    private int recQuantity;
    private int retQuantity;
    private String uom;
    private double price;
    private double recSubTotal;
    private double retSubTotal;
    @ManyToOne
    @JoinColumn(name = "rRMId")
    private RcvReturnMaster rcvReturnMaster;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Products product;
}
