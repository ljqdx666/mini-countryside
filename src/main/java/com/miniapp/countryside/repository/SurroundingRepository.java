package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.Surrounding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SurroundingRepository extends JpaRepository<Surrounding,String> {
    @Query(value = "SELECT * FROM surrounding WHERE creator_name=:creatorName order by created_time desc",nativeQuery = true)
    List<Surrounding> getAllByCreatorName(@Param("creatorName") String creatorName);

    @Query(value = "SELECT * FROM surrounding order by created_time desc",nativeQuery = true)
    List<Surrounding> findAll();

}
