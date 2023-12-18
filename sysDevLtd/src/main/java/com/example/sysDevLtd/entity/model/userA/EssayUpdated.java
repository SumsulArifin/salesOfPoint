package com.example.sysDevLtd.entity.model.userA;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EssayUpdated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eUId;
    private int eId;
    private String title;
    @Column(length = 4000)
    private String column1;
    @Column(length = 4000)
    private String column2;
    @Column(length = 4000)
    private String column3;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(insertable = true, updatable = false)
    private LocalDate createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }

//    @PrePersist
//    protected void onCreate() {
//        createdAt = LocalDate.now();
//        setCreatedBy();
//    }
//
//    private void setCreatedBy() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
//            createdBy = ((UserDetails) authentication.getPrincipal()).getUsername();
//        }
//    }
}
