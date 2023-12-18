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
public class RequisitionMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  reqMId;
    private String invoice;
    private Timestamp reqDate;
    private double total;
    private String pendingFlag;
    private String cancelFlag;
    private String approveFlag;
    private String holdFlag;
    private Timestamp reqApvLimit;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department departments;
}
