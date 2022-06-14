package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson,String> {
//    List<Lesson> findAll
    List<Lesson> findByTitleLike(String title);

    Optional<Lesson> findByTitleAndTeacherName(String title,String teacherName);
}
