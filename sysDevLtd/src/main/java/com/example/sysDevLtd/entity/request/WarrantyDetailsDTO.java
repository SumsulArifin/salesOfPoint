package com.example.sysDevLtd.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class WarrantyDetailsDTO {

    private String firstName;
    private String productName;
    private Date saleDate;
    private long daysLeft;

    public WarrantyDetailsDTO(String customerFirstName, String productName,Date saleDate, long daysLeft) {
        this.firstName = customerFirstName;
        this.productName = productName;
        this.saleDate=saleDate;
        this.daysLeft = daysLeft;
    }

    // Getters and setters (omitted for brevity)
}
