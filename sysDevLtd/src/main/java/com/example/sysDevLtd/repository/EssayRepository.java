package com.example.sysDevLtd.repository;

import com.example.sysDevLtd.entity.model.userA.Essay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EssayRepository extends JpaRepository<Essay, Integer> {
    List<Essay> findByTitleContainingIgnoreCase(String searchTerm);
}
