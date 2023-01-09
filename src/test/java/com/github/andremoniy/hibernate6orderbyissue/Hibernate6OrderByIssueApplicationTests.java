package com.github.andremoniy.hibernate6orderbyissue;

import com.github.andremoniy.hibernate6orderbyissue.model.Company;
import com.github.andremoniy.hibernate6orderbyissue.model.Department;
import com.github.andremoniy.hibernate6orderbyissue.service.CompanyService;
import com.github.andremoniy.hibernate6orderbyissue.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Hibernate6OrderByIssueApplicationTests {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private DepartmentService departmentService;

    @Test
    void shouldFetchCompanyByName() {
        // Given
        Company company = new Company();
        company.setName("Foo Company");
        company = companyService.save(company);

        Department department = new Department();
        department.setCompany(company);
        department.setDepartmentCode("1234567");
        department.setName("Foo Department");
        departmentService.save(department);

        // When
        Optional<Company> companyOptional = companyService.findCompanyByName("Foo Company");

        // Then
        assertTrue(companyOptional.isPresent());
        assertEquals("Foo Department", companyOptional.get().getDepartments().iterator().next().getName());
    }

}
