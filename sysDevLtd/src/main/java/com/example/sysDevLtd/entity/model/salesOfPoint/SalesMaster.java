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
public class SalesMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sMasterId;

    private String invoice;
    private Timestamp salesDate;
    private String returnFlag;
    private Timestamp returnDate;
    private double total;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "depId")
    private Department departments;
}