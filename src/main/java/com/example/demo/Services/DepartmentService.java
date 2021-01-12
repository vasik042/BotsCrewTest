package com.example.demo.Services;

import com.example.demo.Entities.Department;
import com.example.demo.Entities.Lector;
import com.example.demo.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService (DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public Department addDepartment (Department department){
        return departmentRepository.save(department);
    }

    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }
}
