package com.example.sysDevLtd.repository;

import com.example.sysDevLtd.entity.model.pos.Product;
import com.example.sysDevLtd.entity.model.pos.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {

    @Query("SELECT s.warranty.endDate FROM Sale s WHERE s.invoiceNumber = :invoiceNumber")
    Date findWarrantyEndDateByInvoiceNumber(@Param("invoiceNumber") long invoiceNumber);

}
