package com.example.sysDevLtd.repository;

import com.example.sysDevLtd.entity.model.userA.EssayUpdated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EssayUpdatedRepository extends JpaRepository<EssayUpdated,Integer> {
}
