package com.example.demo.Repositories;

import com.example.demo.Entities.Department;
import com.example.demo.Entities.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Transactional
    Department findByName(String name);
}
