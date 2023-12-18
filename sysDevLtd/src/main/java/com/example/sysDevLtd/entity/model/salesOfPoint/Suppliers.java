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
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int suppliersID;
    private String name;
    private  String contactPerson;
   private String  contactPersonPhone;
   private String status;

}
