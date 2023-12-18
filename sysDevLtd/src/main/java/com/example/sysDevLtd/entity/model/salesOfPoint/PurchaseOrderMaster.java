package com.example.sysDevLtd.entity.model.salesOfPoint;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseOrderMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pOMid;

    private String invoice;
    private Timestamp poDate;
    private String pendingFlag;
    private String cancelFlag;
    private String rcvPoFlag;
    private String holdFlag;
    private Timestamp approveDate;
    private double apvTotal;
    private Timestamp rcvLimit;
    private String shippingAddr;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department departments;

    @ManyToOne
    @JoinColumn(name = "approveRMid")
    private ApproveReqMaster approveReqMaster;
}