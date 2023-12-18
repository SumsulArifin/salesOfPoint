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
public class SalesReturnMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sReturnMId;

    private String invoice;
    private Timestamp returnDate;
    private Timestamp saleDate;
    private double salesTotal;
    private double returnTotal;

    @ManyToOne
    @JoinColumn(name = "sMasterId")
    private SalesMaster salesMaster;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "depId")
    private Department departments;
}