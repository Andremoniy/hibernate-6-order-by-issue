package com.github.andremoniy.hibernate6orderbyissue.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @OrderBy("departmentCode DESC")
    private Set<Department> departments;

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
