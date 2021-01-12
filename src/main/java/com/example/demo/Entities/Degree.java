package com.example.demo.Entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "degrees")
public class Degree {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name = "degree_id")
    private int id;

    private String name;

    @OneToMany(mappedBy = "degree", fetch = FetchType.EAGER)
    private Set<Lector> lectors;

    public Degree() {
    }

    public Degree(String degree) {
        this.name = degree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(Set<Lector> lectors) {
        this.lectors = lectors;
    }
}
