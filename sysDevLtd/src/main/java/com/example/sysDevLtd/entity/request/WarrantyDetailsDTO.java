package com.example.sysDevLtd.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class WarrantyDetailsDTO {

    private Long saleId;
    private String firstName;
    private String productName;
    private Date saleDate;
    private Date endDate;
    private long daysLeft;

    public WarrantyDetailsDTO(Long saleId,String customerFirstName, String productName,Date saleDate, Date endDate, long daysLeft) {
        this.saleId = saleId;
        this.firstName = customerFirstName;
        this.productName = productName;
        this.saleDate=saleDate;
        this.endDate=endDate;
        this.daysLeft = daysLeft;
    }

    // Getters and setters (omitted for brevity)
}
