package com.example.demo.Services;

import com.example.demo.Entities.Lector;
import com.example.demo.Repositories.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorService {

    private LectorRepository lectorRepository;

    @Autowired
    public LectorService (LectorRepository lectorRepository){
        this.lectorRepository = lectorRepository;
    }

    public Lector addLector(Lector lector){
        return lectorRepository.save(lector);
    }

    public List<Lector> findAll() {
        return lectorRepository.findAll();
    }
}
