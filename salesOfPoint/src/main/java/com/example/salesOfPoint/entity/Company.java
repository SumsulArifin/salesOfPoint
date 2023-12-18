package com.example.salesOfPoint.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iD;
    private String name;
    @Column(length = 50000000)
    private byte[] logo;
    private String mimetype;
    private String filename;
    private Date imageLastUpdate;
}

