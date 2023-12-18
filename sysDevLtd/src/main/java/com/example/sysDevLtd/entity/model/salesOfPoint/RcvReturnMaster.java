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
public class RcvReturnMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rRMId;

    private String invoice;
    private Timestamp returnDate;
    private Timestamp recDate;
    private double recTotal;
    private double returnTotal;

    @ManyToOne
    @JoinColumn(name = "rMasterId")
    private ReceiveMaster receiveMaster;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department departments;
}