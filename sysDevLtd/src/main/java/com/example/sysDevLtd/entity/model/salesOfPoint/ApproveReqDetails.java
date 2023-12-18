package com.example.sysDevLtd.entity.model.salesOfPoint;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ApproveReqDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int proId;
    private int quantity;
    private String uom;
    private double price;
    private double subTotal;

    @ManyToOne
    @JoinColumn(name = "approveRMid")
    private ApproveReqMaster approveReqMaster;
}