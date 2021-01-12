package com.example.demo.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private int id;

    private String name;

    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "lectorsInDepartment",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id"))
    private Set<Lector> lectors;

    @OneToOne (fetch = FetchType.EAGER)
    private Lector head_of_department;

    public Department() {
    }

    public Department(String name, Lector head_of_department) {
        this.name = name;
        this.head_of_department = head_of_department;
        head_of_department.setDepartment(this);
        this.lectors = new HashSet<>();
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

    public Lector getHead_of_department() {
        return head_of_department;
    }

    public void setHead_of_department(Lector head_of_department) {
        this.head_of_department = head_of_department;
    }

    public Set<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(Set<Lector> lectors) {
        this.lectors = lectors;
    }
}
