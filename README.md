# Hibernate 6: @OrderBy issue

This repository demonstrates an issue with the `jakarta.persistence.@OrderBy` annotation in Hibernate 6.

To reproduce, run `mvn clean test` or the `Hibernate6OrderByIssueApplicationTests` test directly.

The error is:
```
o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Error: 42122, SQLState: 42S22
o.h.engine.jdbc.spi.SqlExceptionHelper   : Column "D1_0.DEPARTMENTCODE" not found; SQL statement:
select c1_0.id,d1_0.company_id,d1_0.department_code,d1_0.name,c1_0.name from company c1_0 left join department d1_0 on c1_0.id=d1_0.company_id where c1_0.name=? order by d1_0.departmentCode desc [42122-214]
```

Basically, under certain conditions the column name provided in the `OrderBy` annotation is not transformed to the physical name of the column in the database.

This is a combination of the three different conditions:
1) The field used in the `OrderBy` should be a part of a composite key on the mapped entity. In our case this is `DepartmentId` composite key:
```
public class DepartmentId implements Serializable {

    private Company company;
    private String departmentCode;

}
```

2) The field used in the `OrderBy` entity should contain more than a word in its name (if we rename `departmentCode` into `code`, the issue goes away).
3) There should be an HQL query that uses `LEFT JOIN FETCH` on the problematic entity.
```
    @Query("""
            SELECT c 
            FROM Company c 
            LEFT JOIN FETCH c.departments 
            WHERE c.name = :name
            """
    )
    Optional<Company> findCompanyByName(@Param("name") String name);
```

In this particular case the `LEFT JOIN FETCH c.departments` is needed in order to fetch departments for the company entity. 
