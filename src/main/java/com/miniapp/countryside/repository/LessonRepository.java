package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson,String> {

    @Query(value = "select * from lesson where checked=0 order by created_time asc ",nativeQuery = true)
    List<Lesson> findUnchecked();

    @Query(value = "select * from lesson where checked=1 order by created_time asc ",nativeQuery = true)
    List<Lesson> findPassed();

    @Query(value = "select u from Lesson u where u.title like :title and u.checked=true order by u.createdTime desc ")
    List<Lesson> findByTitleLike(@Param("title") String title);

    @Query(value = "select u from Lesson u where u.classification=:classification and u.checked=true order by u.createdTime desc ")
    List<Lesson> findByClassification(@Param("classification") String classification);

    Optional<Lesson> findByTitleAndTeacherName(String title,String teacherName);
}
