package com.github.andremoniy.hibernate6orderbyissue.service;

import com.github.andremoniy.hibernate6orderbyissue.model.Department;
import com.github.andremoniy.hibernate6orderbyissue.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }
}
