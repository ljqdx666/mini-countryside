package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.Surrounding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SurroundingRepository extends JpaRepository<Surrounding,String> {
    List<Surrounding> getAllByCreatorName(String creatorName);

    @Query(value = "SELECT * FROM surrounding order by created_time desc",nativeQuery = true)
    List<Surrounding> findAll();
}
