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
public class ReceiveMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rMasterId;

    private String invoice;
    private Timestamp poDate;
    private String pendingFlag;
    private String cancelFlag;
    private String rcvPoFlag;
    private String holdFlag;
    private Timestamp rcvDate;
    private double apvTotal;
    private double rcvTotal;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department departments;

    @ManyToOne
    @JoinColumn(name = "poMId")
    private PurchaseOrderMaster purchaseOrderMaster;
}