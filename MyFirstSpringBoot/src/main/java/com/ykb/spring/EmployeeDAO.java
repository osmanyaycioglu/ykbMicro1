package com.ykb.spring;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByNameAndSurname(String name,
                                        String surname);

    @Query(value = "select e from Employee e where e.name = :isim")
    List<Employee> myCustomQuery(@Param("isim") String name);

    @Query(value = "select * from EMPLOYEE where name = :isim", nativeQuery = true)
    List<Employee> myNativeCustomQuery(@Param("isim") String name);


}
