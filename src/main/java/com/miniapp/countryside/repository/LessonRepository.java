package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson,String> {

    @Query(value = "select * from lesson where checked=0 order by created_time asc ",nativeQuery = true)
    List<Lesson> findUnchecked();

    @Query(value = "select * from lesson where checked=1 order by created_time asc ",nativeQuery = true)
    List<Lesson> findPassed();

    List<Lesson> findByTitleLike(String title);

    Optional<Lesson> findByTitleAndTeacherName(String title,String teacherName);
}
