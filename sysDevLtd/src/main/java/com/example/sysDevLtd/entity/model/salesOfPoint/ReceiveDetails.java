package com.example.sysDevLtd.entity.model.salesOfPoint;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReceiveDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rDetailsId;

    private int proId;
    private int poQuantity;
    private String uom;
    private double poPrice;
    private double poSubTotal;
    private int rcvQuantity;
    private double rcvPrice;
    private double rcvSubTotal;

    @ManyToOne
    @JoinColumn(name = "rMasterId")
    private ReceiveMaster receiveMaster;
}
