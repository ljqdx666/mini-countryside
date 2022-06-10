package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video,String> {
//    Optional<Video> findById(String id);
}
