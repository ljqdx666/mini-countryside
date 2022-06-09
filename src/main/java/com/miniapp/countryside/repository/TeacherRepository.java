package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<User,String> {
}
