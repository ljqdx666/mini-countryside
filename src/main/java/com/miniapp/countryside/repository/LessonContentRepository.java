package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.LessonContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonContentRepository extends JpaRepository<LessonContent,String> {
    @Query(value = "SELECT * FROM lesson_content WHERE lesson_id=:lessonId order by created_time asc ",nativeQuery = true)
    List<LessonContent> findByLessonId(@Param("lessonId") String lessonId);

    @Modifying
    void deleteAllByLessonId(String lessonId);
}
