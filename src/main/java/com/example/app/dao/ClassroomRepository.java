package com.example.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.Classroom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    @Query("SELECT c.id, c.name, c.size, c.level, c.ecole FROM Classroom c WHERE c.ecole.id = :ecoleId")
    List<Object[]> findAllByEcoleId(@Param("ecoleId") Long ecoleId);
}
