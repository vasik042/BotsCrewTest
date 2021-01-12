package com.example.demo.Services;

import com.example.demo.Entities.Degree;
import com.example.demo.Repositories.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DegreeService {

    private DegreeRepository degreeRepository;

    @Autowired
    public DegreeService (DegreeRepository degreeRepository){
        this.degreeRepository = degreeRepository;
    }

    public Degree addDegree(Degree degree){
        return degreeRepository.save(degree);
    }

}
