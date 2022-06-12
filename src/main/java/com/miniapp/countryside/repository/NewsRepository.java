package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NewsRepository extends JpaRepository<News,String> {
//    Optional<News> findByTitle(String title);

    News getById(String id);

//    Page<News> findAll(Pageable pageable);
    List<News> findByTitleLike(String title);

    @Query(value = "SELECT * FROM news order by created_time desc",nativeQuery = true)
    List<News> findAll();
}
