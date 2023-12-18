package com.example.sysDevLtd.repository;

import com.example.sysDevLtd.entity.model.pos.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails,Integer> {
}
