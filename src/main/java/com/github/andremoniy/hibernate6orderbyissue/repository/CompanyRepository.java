package com.github.andremoniy.hibernate6orderbyissue.repository;

import com.github.andremoniy.hibernate6orderbyissue.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("""
            SELECT c 
            FROM Company c 
            LEFT JOIN FETCH c.departments 
            WHERE c.name = :name
            """
    )
    Optional<Company> findCompanyByName(@Param("name") String name);

}
