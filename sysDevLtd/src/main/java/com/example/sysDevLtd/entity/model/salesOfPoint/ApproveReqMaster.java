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
public class ApproveReqMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int approveRMid;

    private String invoice;
    private Timestamp reqDate;
    private String pendingFlag;
    private String cancelFlag;
    private String purchOrdFlag;
    private String holdFlag;
    private Timestamp approveDate;
    private double total;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department departments;

    @ManyToOne
    @JoinColumn(name = "reqMId")
    private RequisitionMaster requisitionMaster;
}
