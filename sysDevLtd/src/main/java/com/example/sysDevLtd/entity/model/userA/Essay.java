package com.example.sysDevLtd.entity.model.userA;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Essay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;
    private String title;
    @Column(length = 8000,columnDefinition = "TEXT")
    private String column1;
    @Column(length = 8000,columnDefinition = "TEXT")
    private String column2;
    @Column(length = 8000,columnDefinition = "TEXT")
    private String column3;
}
