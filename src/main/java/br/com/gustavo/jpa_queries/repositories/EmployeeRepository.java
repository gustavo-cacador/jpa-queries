package br.com.gustavo.jpa_queries.repositories;

import br.com.gustavo.jpa_queries.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT obj FROM Employee obj JOIN FETCH obj.department")
    List<Employee> searchAll();

    @Query(value = "SELECT obj FROM Employee obj JOIN FETCH obj.department",
            countQuery = "SELECT COUNT(obj) FROM Employee obj JOIN obj.department")
    Page<Employee> searchAll(Pageable pageable);
}
