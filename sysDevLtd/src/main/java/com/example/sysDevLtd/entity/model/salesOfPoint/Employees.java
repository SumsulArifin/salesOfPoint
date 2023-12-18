package com.example.sysDevLtd.entity.model.salesOfPoint;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empID;
    private String name;
    private String phone;
    private String email;
    @Column(length = 50000000)
    private byte[] image;
    private String mimetype;
    private String filename;
    private Date imageLastUpdate;
    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department department;

}
