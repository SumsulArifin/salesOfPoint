package com.example.sysDevLtd.entity.model.pos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String productName;
    private String productType;
    private String ownerNumber;

    @OneToOne(cascade = CascadeType.ALL) // Define CascadeType based on your needs
    @JoinColumn(name = "productDetailsId") // Name of the foreign key column in Product table
    private ProductDetails productDetails;


}
