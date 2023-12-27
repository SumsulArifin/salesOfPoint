package com.example.sysDevLtd.repository;

import com.example.sysDevLtd.entity.model.pos.Product;
import com.example.sysDevLtd.entity.model.pos.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

    @Query(value = "SELECT * FROM Purchases p WHERE p.stock_id = :stockId", nativeQuery = true)
    List<Purchase> findByStockId(@Param("stockId") Long stockId);
}
