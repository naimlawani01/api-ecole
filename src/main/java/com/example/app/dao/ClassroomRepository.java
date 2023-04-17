package com.example.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.Classroom;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    List<Classroom> findByEcoleId(Long postId);
}
