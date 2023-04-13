package com.example.app.dao;

import com.example.app.model.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EcoleRepository extends JpaRepository <Ecole, Long>  {
}
