package com.example.sysDevLtd.entity.model.pos;

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
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productDetailsId;
    private int registrationNo;
    private int chassisNumber;
    private int engineNumber;
    private int cubicCapacity;
    private int RPM;
    private int noOfTyres;
    private int numberOfCylinders;
    private String yearOfManufacture;
    private String Body;
    private String engineCapacity;
    private String mileage;
    private String drive;
    private String seatingCapacity;
    private String fuelType;
    private String exteriorColor;
    private String carFeatures;


}
