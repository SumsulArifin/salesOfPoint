package com.example.sysDevLtd.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class StockRepositoryImpl {
    @Autowired
     EntityManager entityManager;




    public long countByProductName(String productName) {
        Query query = entityManager.createNativeQuery(
                "SELECT COUNT(*) FROM stocks s JOIN product p ON s.product_id = p.product_id WHERE p.product_name = :productName"
        );
        query.setParameter("productName", productName);
        return ((Number) query.getSingleResult()).longValue();
    }
}
