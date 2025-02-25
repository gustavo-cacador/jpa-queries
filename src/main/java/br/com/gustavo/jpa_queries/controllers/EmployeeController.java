package br.com.gustavo.jpa_queries.controllers;

import br.com.gustavo.jpa_queries.entities.Employee;
import br.com.gustavo.jpa_queries.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.searchAll(pageable);
    }
}
