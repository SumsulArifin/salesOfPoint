package com.example.sysDevLtd.repository;

import com.example.sysDevLtd.entity.model.pos.TaxAndVat;
import com.example.sysDevLtd.entity.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxAndVatRepository extends JpaRepository<TaxAndVat, Long> {
}
