package com.example.sysDevLtd.repository;

import com.example.sysDevLtd.entity.model.pos.Customer;
import com.example.sysDevLtd.entity.model.pos.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
