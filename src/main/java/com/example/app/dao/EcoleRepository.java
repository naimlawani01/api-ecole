package com.example.app.dao;

import com.example.app.model.Classroom;
import com.example.app.model.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EcoleRepository extends JpaRepository <Ecole, Long>  {
}
