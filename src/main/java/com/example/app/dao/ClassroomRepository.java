package com.example.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}
