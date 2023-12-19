package com.example.sysDevLtd.repository;

import com.example.sysDevLtd.entity.model.pos.Product;
import com.example.sysDevLtd.entity.model.pos.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
