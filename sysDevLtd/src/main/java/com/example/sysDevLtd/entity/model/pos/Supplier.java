package com.example.sysDevLtd.entity.model.pos;

import com.example.sysDevLtd.entity.model.users.SupplierType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;
    @Enumerated(EnumType.STRING)
    private SupplierType supplierType;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;
    
}
