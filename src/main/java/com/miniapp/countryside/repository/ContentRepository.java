package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content,String> {
    @Query(value = "SELECT * FROM content WHERE lesson_id=:lessonId order by created_time asc ",nativeQuery = true)
    List<Content> findByLessonId(@Param("lessonId") String lessonId);

    @Modifying
    void deleteAllByLessonId(String lessonId);
}
