package com.example.sysDevLtd.entity.model.pos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleId;

    @Column(name = "invoiceNumber", unique = true)
    private long invoiceNumber;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "sale_date")
    private Date saleDate;

    @Column(name = "sale_price")
    private int price;

    @Column(name = "discount")
    private int discount;

    @Column(name = "total_amount")
    private int totalAmount;
    @ManyToOne
    @JoinColumn(name = "stockId")
    private Stock stock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warrantyId")
    private Warranty warranty;


    @PrePersist
    public void generateInvoiceNumber() {

        this.invoiceNumber = generateUniqueInvoiceNumber();
    }

    private long generateUniqueInvoiceNumber() {
        long timestamp = System.currentTimeMillis();
        long randomNumber = (long) (Math.random() * 1000);
        return Long.parseLong(String.valueOf(timestamp) + String.valueOf(randomNumber));
    }



}
