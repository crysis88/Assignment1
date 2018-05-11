package com.assignment.resource;

import com.assignment.model.Employee;
import com.assignment.service.EmployeeService;
import io.katharsis.legacy.queryParams.QueryParams;
import io.katharsis.legacy.repository.ResourceRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class EmployeeResource implements ResourceRepository<Employee,Integer>{

    @Inject
    private EmployeeService employeeService;

    @Override
    public Employee findOne(Integer id, QueryParams queryParams) {
        return employeeService.getEmployee(id);
    }

    @Override
    public Iterable<Employee> findAll(QueryParams queryParams) {
        return  employeeService.getAllEmployee();
    }

    @Override
    public Iterable<Employee> findAll(Iterable<Integer> integers, QueryParams queryParams) {
       return null;
    }

    @Override
    public void delete(Integer id) {
        employeeService.deleteEmployee(id);

    }

    @Override
    public <S extends Employee> S save(S entity) {
        Employee employee = findOne(entity.getId(), null);
       Employee empEntity= entity;
        if (employee == null) {
            return (S) employeeService.addEmployee(empEntity);
        } else {
            return (S)employeeService.updateEmployee(empEntity);
        }

    }
}
