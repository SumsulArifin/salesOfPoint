package com.example.sysDevLtd.repository;
import com.example.sysDevLtd.entity.model.userA.AssignDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AssignDetailsRepository extends JpaRepository<AssignDetails, Integer> {

    @Query("select a from AssignDetails a where a.assign_master.a_M_Id=?1")
    public List<AssignDetails> findByAssign_master(int id);

}
