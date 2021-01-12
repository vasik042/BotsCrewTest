package com.example.demo.Repositories;

import com.example.demo.Entities.Department;
import com.example.demo.Entities.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Integer> {
}
