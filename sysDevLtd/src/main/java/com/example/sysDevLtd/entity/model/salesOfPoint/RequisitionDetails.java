package com.example.sysDevLtd.entity.model.salesOfPoint;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RequisitionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  requisitionDetailsId;
    private int quantity;
    private String uom;
    private double price;
    private double subTotal;

    @ManyToOne
    @JoinColumn(name = "requisitionMasterId")
    private RequisitionMaster requisitionMaster;
    @ManyToOne
    @JoinColumn(name = "productID")
    private Products products;
}
