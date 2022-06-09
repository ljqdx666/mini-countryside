package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsRepository extends JpaRepository<News,Integer> {
    Optional<News> findByTitle(String title);
}
