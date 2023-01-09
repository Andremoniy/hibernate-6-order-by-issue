package com.github.andremoniy.hibernate6orderbyissue.repository;

import com.github.andremoniy.hibernate6orderbyissue.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
