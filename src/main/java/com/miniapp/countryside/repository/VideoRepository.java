package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video,String> {
//    Optional<Video> findById(String id);
    Video getById(String id);

//    Page<Video> findAll(Pageable pageable);

    List<Video> findAll();
}
