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
    private  String terms1;
    private  String terms2;
    private  String terms3;
    private  String terms4;
    private  String terms5;
    private  String terms6;
    private  String terms7;
    private  String terms8;
    private  String terms9;
    private  String terms10;
    private  String comment;

}
