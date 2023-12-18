package com.example.sysDevLtd.entity.model.pos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String productType;
    private String productOwner;
    private String ownerNumber;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "productDetailsId")
    private ProductDetails productDetails;
}
