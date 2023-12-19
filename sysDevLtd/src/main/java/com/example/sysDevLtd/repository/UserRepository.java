package com.example.sysDevLtd.repository;

import com.example.sysDevLtd.entity.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
