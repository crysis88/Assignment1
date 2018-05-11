package com.assignment.service;

import com.assignment.model.Employee;
import com.assignment.repository.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public class EmployeeService {

    static Logger log = LogManager.getLogger(EmployeeService.class);

    @Inject
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        log.info("Adding employee " + employee);
        return employeeRepository.addEmployee(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    public Employee getEmployee(int id) {
        return employeeRepository.getEmployee(id);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

}
