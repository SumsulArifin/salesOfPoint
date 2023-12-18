package com.example.sysDevLtd.entity.model.salesOfPoint;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;
    private String name;
    private String phone;
    private String email;
}
