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
public class Warranty extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long warrantyId;
    private Date startDate;
    private Date endDate;
    private  String trams1;
    private  String trams2;
    private  String trams3;
    private  String trams4;
    private  String trams5;
    private  String trams6;
    private  String trams7;
    private  String trams8;
    private  String trams9;
    private  String trams10;
    private  String comment;

}
