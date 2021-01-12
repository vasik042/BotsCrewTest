package com.example.demo.Entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lectors")
public class Lector {

    @Id
    @GeneratedValue
    @Column(name = "lector_id")
    private int id;

    private String name;
    private float salary;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="degree_id", nullable=false)
    private Degree degree;

    @ManyToMany(mappedBy = "lectors", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Department> departments;

    @OneToOne(mappedBy = "head_of_department", fetch = FetchType.EAGER)
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Department department;

    public Lector() {
    }

    public Lector(String name, Degree degree, float salary) {
        this.name = name;
        this.degree = degree;
        this.salary = salary;
        this.departments = new HashSet<>();
    }

    public void addDepartment(Department department){
        getDepartments().add(department);
        department.getLectors().add(this);
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

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "name='" + name + '\'' +
                '}';
    }
}
