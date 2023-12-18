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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    private String name;
    private  String userName;
    private String password;
    private String userRole;
    private Date created;
    private  String createdBy;
    private Date updated;
    private  String updatedBy;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "empID")
    private Employees employees;


}
