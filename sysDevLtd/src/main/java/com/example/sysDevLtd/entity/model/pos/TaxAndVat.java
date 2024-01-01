package com.example.sysDevLtd.entity.model.pos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "taxAndVat")
public class TaxAndVat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taxAndVatId;

    @Column(name = "tradePrice")
    private Integer tradePrice;

    @Column(name = "tax")
    private Integer tax;

    @Column(name = "vat")
    private Integer vat;

    @Column(name = "transportationFee")
    private Integer transportationFee;

    @Column(name = "others")
    private Integer others;

    @Column(name = "grossPrice")
    private Integer grossPrice;

    @Column(name = "mrp")
    private Integer mrp;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
//    private Product product;
//
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "product_id")
////    private Product product;
//
//    @ManyToOne
//    @JoinColumn(name = "supplierId")
//    private Supplier supplier;
}
