package com.example.sysDevLtd.entity.model.salesOfPoint;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseOrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pODetailsId;
    private int apvQuantity;
    private String uom;
    private double apvPrice;
    private double apvSubTotal;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "pOMid")
    private PurchaseOrderMaster purchaseOrderMaster;
}
