package com.example.sysDevLtd.repository;

import com.example.sysDevLtd.entity.model.pos.Product;
import com.example.sysDevLtd.entity.model.pos.Stock;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

    @Query("SELECT p.productName, p.productId, s.supplierId, s.supplierName " +
            "FROM Stock st " +
            "JOIN st.product p " +
            "JOIN st.supplier s " +
            "WHERE st.stockId = :stockId")
    List<Object[]> findProductNameProductIdAndSupplierByStockId(@Param("stockId") Long stockId);

//    @Query("SELECT COUNT(p), p.productName, p.productId, s.supplierId, s.supplierName " +
//            "FROM Stock st " +
//            "JOIN st.product p " +
//            "JOIN st.supplier s " +
//            "WHERE st.stockId = :stockId")
//    List<Object[]> countAndFindDetailsByStockId(@Param("stockId") Long stockId);

    @Query("SELECT COUNT(s) FROM Stock s WHERE s.product.productId = :productId")
    long countByProductId(Long productId);

    List<Stock> findByStatusTrue();

//    private final EntityManager entityManager;
//    @Autowired
//    public StockRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    public long countByProductName(String productName) {
//        Query query = entityManager.createNativeQuery(
//                "SELECT COUNT(*) FROM stocks s JOIN products p ON s.product_id = p.product_id WHERE p.product_name = :productName"
//        );
//        query.setParameter("productName", productName);
//        return ((Number) query.getSingleResult()).longValue();
//    }

}
