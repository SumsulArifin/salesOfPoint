package com.example.sysDevLtd.entity.model.pos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productDetailsId;
    private String registrationNo;
    private String chassisNumber;
    private String engineNumber;
    private String cubicCapacity;
    private String RPM;
    private Integer noOfTyres;
    private Integer numberOfCylinders;
    private Date yearOfManufacture;
    private String Body;
    private String engineCapacity;
    private Integer mileage;
    private String drive;
    private Integer seatingCapacity;
    private String fuelType;
    private String exteriorColor;
    private String carFeatures;


}
