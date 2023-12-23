package com.example.sysDevLtd.repository;


import com.example.sysDevLtd.entity.model.pos.Author;
import com.example.sysDevLtd.entity.model.pos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
