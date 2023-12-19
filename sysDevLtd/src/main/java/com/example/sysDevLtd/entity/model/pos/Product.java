package com.example.sysDevLtd.entity.model.pos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String productType;
    private String productOwner;
    private String ownerNumber;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "productDetailsId")
    private ProductDetails productDetails;



}
