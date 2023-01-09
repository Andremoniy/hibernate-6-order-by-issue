package com.github.andremoniy.hibernate6orderbyissue.model;

import jakarta.persistence.*;

@Entity
@IdClass(DepartmentId.class)
public class Department {

    @Id
    @ManyToOne
    private Company company;

    @Id
    private String departmentCode;

    private String name;

    public String getName() {
        return name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentCode(String departmentId) {
        this.departmentCode = departmentId;
    }
}
